package com.aleksandrbogomolov.configuration

import com.aleksandrbogomolov.helper.PropertyHelper
import org.apache.activemq.broker.BrokerService

object BrokerConfiguration {

  val broker = new BrokerService

  broker.setBrokerName(PropertyHelper.getProperty("broker.name"))

  broker.setUseJmx(true)

  broker.addConnector(PropertyHelper.getProperty("broker.host"))

  broker.addConnector(PropertyHelper.getProperty("broker.vm"))
}
