package com.qwerfah.rpg_logic_engine

import akka.actor.ActorSystem
import cats.implicits.catsSyntaxOptionId
import com.qwerfah.rpg_logic_engine.engine.session.SessionActor
import com.typesafe.config.Config
import com.typesafe.config.ConfigFactory

@main def hello: Unit =
  val actorSystem = ActorSystem("test-session-system")

  try
    val appSettings = AppSettings.fromConfig(ConfigFactory.load(""))

    val sessionActor = actorSystem.actorOf(SessionActor.props(appSettings))
    // launch other system components
  catch
    case e: Throwable =>
      println(e)
      // resources deallocation
      actorSystem.terminate()
