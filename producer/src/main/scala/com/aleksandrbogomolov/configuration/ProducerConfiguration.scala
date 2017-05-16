package com.aleksandrbogomolov.configuration

import java.io.File

import com.typesafe.config.ConfigFactory
import org.apache.activemq.ActiveMQConnectionFactory
import org.apache.camel.component.jms.JmsComponent
import org.apache.camel.impl.DefaultCamelContext

class ProducerConfiguration {

  val config = ConfigFactory.parseFile(new File("config/application.conf")).resolve

  val ctx = new DefaultCamelContext

  val connectionFactory = new ActiveMQConnectionFactory(config.getString("producer.host"))

  ctx.addComponent("jms", JmsComponent.jmsComponentAutoAcknowledge(connectionFactory))
}
