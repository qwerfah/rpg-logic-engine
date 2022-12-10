package com.qwerfah.rpg_logic_engine.engine.time

import com.qwerfah.rpg_logic_engine.engine.action.Action

import scala.collection.mutable.{ListBuffer, Map as MutableMap}
import java.util.UUID
import scala.concurrent.duration.Duration
import java.util.{TimerTask, Timer}

trait TimeModel(step: Duration):
  def schedule(newActions: (UUID, Seq[(Action, Int)])*): Unit
