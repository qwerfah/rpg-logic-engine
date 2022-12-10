package com.qwerfah.rpg_logic_engine.api

import akka.actor.Actor
import akka.actor.Props
import com.qwerfah.rpg_logic_engine.AppSettings

/** Receives messages from api implementation and transforms it to actions for session and all
  * active session elements represented by actors.
  * @param appSettings
  *   application settings from app.conf
  */
class ApiActor(appSettings: AppSettings) extends Actor:
  override def receive: Actor.Receive = ???

object ApiActor:
  def props(appSettings: AppSettings): Props = Props(new ApiActor(appSettings))
