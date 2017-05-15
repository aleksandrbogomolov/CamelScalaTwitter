package com.aleksandrbogomolov

import com.aleksandrbogomolov.publisher.Publisher
import com.aleksandrbogomolov.stream.FilterStream

object Main extends App {

  val filters = Array("#java", "#scala", "#kotlin", "#groovy", "#haskell")

  private val filterStream = new FilterStream(filters)

  val stream = filterStream.start()

  stream.foreachRDD(_.foreach(Publisher.publish))

  filterStream.sparkConf.streamingContext.start()

  filterStream.sparkConf.streamingContext.awaitTermination()
}
