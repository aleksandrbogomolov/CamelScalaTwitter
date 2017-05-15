package com.aleksandrbogomolov.publisher

import com.aleksandrbogomolov.configuration.ProducerConfiguration

object Publisher {

  private val producer = new ProducerConfiguration()

  val sender = producer.getTemplate

  val publish = (twit: String) => sender.sendBody(producer.config.getString("producer.queue"), twit)
}
