package com.aleksandrbogomolov.stream

import com.aleksandrbogomolov.configuration.SparkConfiguration
import org.apache.spark.streaming.twitter.TwitterUtils

class FilterStream(filters: Array[String]) {

  val configuration = new SparkConfiguration

  def start() = {
    val statuses = TwitterUtils.createStream(configuration.streamingContext, configuration.auth, filters)
    statuses.foreachRDD(_.foreachPartition(_.foreach(println)))
    configuration.streamingContext.start()
    configuration.streamingContext.awaitTermination()
  }
}
