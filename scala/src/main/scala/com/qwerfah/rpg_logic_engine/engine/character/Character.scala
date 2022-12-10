package com.qwerfah.rpg_logic_engine.engine.character

import akka.actor.ActorRef
import java.util.UUID

class Character(val id: UUID, val info: CharacterInfo, val ctor: ActorRef)