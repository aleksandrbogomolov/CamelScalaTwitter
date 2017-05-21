package com.aleksandrbogomolov.helper

import java.io.File

import com.typesafe.config.ConfigFactory

object PropertyHelper {

  val config = ConfigFactory.parseFile(new File("config/application.conf")).resolve

  val getProperty = (key: String) => config.getString(key)
}
