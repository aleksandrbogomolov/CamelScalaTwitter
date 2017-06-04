package com.aleksandrbogomolov

import java.io.File
import javax.jms.ConnectionFactory

import com.typesafe.config.ConfigFactory
import org.apache.activemq.pool.PooledConnectionFactory
import org.apache.camel.builder.RouteBuilder
import org.apache.camel.component.jms.JmsComponent
import org.apache.camel.impl.DefaultCamelContext
import org.apache.camel.{Exchange, Processor}

object WebConsumer extends App {

  val config = ConfigFactory.parseFile(new File("config/application.conf")).resolve()

  val camelContext = new DefaultCamelContext()

  camelContext.addComponent("jms", JmsComponent.jmsComponentAutoAcknowledge(getPoolFactory))

  camelContext.addRoutes(new RouteBuilder() {
    override def configure(): Unit = {
      from(config.getString("web.queue")).process(new Processor {
        override def process(exchange: Exchange): Unit = println(exchange.getIn().getBody.toString)
      })
    }
  })

  def getPoolFactory: ConnectionFactory = {
    val pool = new PooledConnectionFactory(config.getString("web.brokerURL"))
    pool.setMaxConnections(10)
    pool.setMaximumActiveSessionPerConnection(10)
    pool
  }

  camelContext.start()
}
