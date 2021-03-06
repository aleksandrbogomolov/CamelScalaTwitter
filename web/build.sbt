name := "web"

version := "1.0"

scalaVersion := "2.11.11"

libraryDependencies ++= Seq(
  "org.apache.activemq" % "activemq-all" % "5.14.5",
  "org.apache.camel" % "camel-scala" % "2.19.0",
  "org.apache.commons" % "commons-pool2" % "2.4.2",
  "org.scala-lang.modules" % "scala-xml_2.11" % "1.0.6",
  "com.typesafe" % "config" % "1.3.1"
)
