package com.aleksandrbogomolov.configuration

import org.apache.log4j.{Level, Logger}
import org.apache.spark.streaming.{Duration, StreamingContext}
import org.apache.spark.{SparkConf, SparkContext}
import twitter4j.auth.AuthorizationFactory
import twitter4j.conf.ConfigurationContext

class SparkConfiguration {

  val auth = Option(AuthorizationFactory.getInstance(ConfigurationContext.getInstance()))

  val sparkContext = new SparkContext(new SparkConf().setAppName("stream_app").setMaster("local[*]"))

  val streamingContext = new StreamingContext(sparkContext, Duration(5000))

  Logger.getRootLogger.setLevel(Level.ERROR)
}
