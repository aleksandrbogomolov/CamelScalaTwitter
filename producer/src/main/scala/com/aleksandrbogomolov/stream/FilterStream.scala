package com.aleksandrbogomolov.stream

import com.aleksandrbogomolov.configuration.SparkConfiguration
import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.spark.streaming.dstream.DStream
import org.apache.spark.streaming.twitter.TwitterUtils

class FilterStream(filters: Array[String]) {

  val sparkConf = new SparkConfiguration

  def start(): DStream[String] = {
    val statuses = TwitterUtils.createStream(sparkConf.streamingContext, sparkConf.auth, filters)
    val mapper = new ObjectMapper()
    statuses.map(mapper.writeValueAsString(_))
  }
}
