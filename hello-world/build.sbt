
ThisBuild / scalaVersion := "3.0.0"

name := "zio-world"
organization := "macwinux.scala"
version := "1.0"

ThisBuild / scalacOptions ++=
  Seq(
    "-deprecation",
    "-feature",
    "-language:implicitConversions",
    "-unchecked",
    "-Xfatal-warnings",
    "-Yexplicit-nulls",
    "-Ykind-projector",
    "-Ysafe-init",
  ) ++ Seq("-rewrite", "-indent") ++ Seq("-source", "future")

libraryDependencies += "dev.zio" %% "zio" % "1.0.9"
