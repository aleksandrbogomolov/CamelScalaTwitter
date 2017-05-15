name := "producer"

version := "1.0"

scalaVersion := "2.11.11"

libraryDependencies ++= Seq(
  "org.apache.camel" % "camel-core" % "2.19.0",
  "org.apache.camel" % "camel-jms" % "2.19.0",
  "org.apache.camel" % "camel-scala" % "2.19.0",
  "org.apache.activemq" % "activemq-all" % "5.14.5",
  "org.apache.spark" % "spark-streaming_2.11" % "1.5.2",
  "org.apache.spark" % "spark-streaming-twitter_2.11" % "1.5.2",
  "org.scala-lang.modules" % "scala-xml_2.11" % "1.0.6",
  "com.typesafe" % "config" % "1.3.1"
)
