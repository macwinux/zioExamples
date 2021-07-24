
ThisBuild / scalaVersion := "3.0.0"
ThisBuild / organization := "macwinux.scala"
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

lazy val dependencies = Seq(
  libraryDependencies ++= Seq(
    "dev.zio" %% "zio" % "1.0.9"
  ),
)

lazy val hello = (project in file("."))
.settings(name := "zio-world")
.settings(dependencies)