enablePlugins(ScalaJSPlugin)

name := "web"

version := "1.0"

scalaVersion := "2.11.11"

scalaJSUseMainModuleInitializer := true

libraryDependencies ++= Seq(
  "be.doeraene" % "scalajs-jquery_sjs0.6_2.11" % "0.9.1"
)

skip in packageJSDependencies := false
jsDependencies ++= Seq(
  "org.webjars" % "jquery" % "2.1.4" / "2.1.4/jquery.js"
)
