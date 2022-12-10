package com.qwerfah.rpg_logic_engine.engine.session

import com.qwerfah.rpg_logic_engine.engine.action.Action
import com.qwerfah.rpg_logic_engine.AppSettings
import akka.actor.{Actor, Props}
import java.util.UUID
import com.qwerfah.rpg_logic_engine.engine.time.SimpleTimeModel

object SessionActorProtocol:
  trait SessionActorMessage

  final case class ActionMessage(id: UUID, action: Action)

final class SessionActor(appSettings: AppSettings) extends Actor:
  import SessionActorProtocol.*

  val timeModel = SimpleTimeModel(appSettings.timeStep)

  override def receive: Receive =
    case message: ActionMessage =>

object SessionActor:
  def props(appSettings: AppSettings): Props = Props(new SessionActor(appSettings))
