package com.aleksandrbogomolov.publisher

import javax.jms.ConnectionFactory

import com.aleksandrbogomolov.helper.PropertyHelper
import org.apache.activemq.pool.PooledConnectionFactory
import org.apache.camel.component.jms.JmsComponent
import org.apache.camel.impl.DefaultCamelContext

object Publisher {

  val ctx = new DefaultCamelContext

  ctx.addComponent("jms", JmsComponent.jmsComponentAutoAcknowledge(getPoolFactory))

  ctx.start()

  val producer = ctx.createProducerTemplate

  val publish = (twit: String) => {
    producer.sendBody(PropertyHelper.getProperty("producer.queue"), twit)
  }

  def getPoolFactory: ConnectionFactory = {
    val pool = new PooledConnectionFactory(PropertyHelper.getProperty("broker.vm"))
    pool.setMaxConnections(10)
    pool.setMaximumActiveSessionPerConnection(10)
    pool
  }
}
