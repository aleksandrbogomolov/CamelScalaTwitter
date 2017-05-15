package com.aleksandrbogomolov

import com.aleksandrbogomolov.stream.FilterStream

object Main extends App {

  val filters = Array("#java", "#scala", "#kotlin", "#groovy", "#haskell")

  val stream = new FilterStream(filters)

  stream.start()
}
