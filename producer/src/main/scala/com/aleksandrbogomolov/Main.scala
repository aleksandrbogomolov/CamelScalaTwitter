package com.aleksandrbogomolov

import com.aleksandrbogomolov.configuration.BrokerConfiguration
import com.aleksandrbogomolov.publisher.Publisher
import com.aleksandrbogomolov.stream.FilterStream

object Main extends App {

  val filters = Array("#java", "#scala", "#haskell", "#groovy")

  BrokerConfiguration.broker.start()

  val filterStream = new FilterStream(filters)

  val stream = filterStream.start()

  stream.foreachRDD(_.foreach(Publisher.publish))

  filterStream.sparkConf.streamingContext.start()

  filterStream.sparkConf.streamingContext.awaitTermination()
}
