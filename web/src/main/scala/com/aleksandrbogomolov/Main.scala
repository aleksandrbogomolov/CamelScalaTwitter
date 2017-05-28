package com.aleksandrbogomolov

import org.scalajs.jquery.jQuery

import scala.scalajs.js.Dynamic.{global => g}
import scala.scalajs.js.JSApp

object Main extends JSApp {

  override def main(): Unit = setupUI()

  def setupUI(): Unit = {
    jQuery("#clickMeButton").click(() => addClickedMessage())
  }

  def addClickedMessage(): Unit = g.alert("Start the Twitter Feed!")
}
