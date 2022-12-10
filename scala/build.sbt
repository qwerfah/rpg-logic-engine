val scala3Version = "3.2.0"

lazy val root = project
  .in(file("."))
  .settings(
    name                                       := "scala",
    version                                    := "0.1.0-SNAPSHOT",
    scalaVersion                               := scala3Version,
    libraryDependencies += "org.scalameta"     %% "munit"            % "0.7.29" % Test,
    libraryDependencies += "com.typesafe.akka" %% "akka-actor-typed" % "2.6.20",
    libraryDependencies += "com.typesafe"       % "config"           % "1.4.2",
    libraryDependencies += "org.typelevel"     %% "cats-core"        % "2.8.0"
  )
