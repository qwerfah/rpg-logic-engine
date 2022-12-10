package com.qwerfah.rpg_logic_engine.engine.time

import com.qwerfah.rpg_logic_engine.engine.action.Action

import scala.collection.mutable.{ListBuffer, Map as MutableMap}
import java.util.UUID
import scala.concurrent.duration.Duration
import java.util.{TimerTask, Timer}

final case class TimeModelAction(action: Action, stepsToPerform: Int):
  require(stepsToPerform >= 0, "steps to perform action can't be negative number")

class SimpleTimeModel(step: Duration) extends TimeModel(step):
  // Timer task to update action readiness
  private val timerTask: TimerTask = new TimerTask:
    override def run(): Unit = this.synchronized {
      for
        (id, modelActions) <- performingActions
        actionIdx          <- modelActions.indices
      do
        val stepsToPerform = modelActions(actionIdx).stepsToPerform
        if stepsToPerform == 1 then
          readyActions.getOrElseUpdate(id, ListBuffer.empty).append(modelActions(actionIdx).action)
          modelActions.remove(actionIdx)
        else
          modelActions(actionIdx) =
            modelActions(actionIdx).copy(stepsToPerform = stepsToPerform - 1)
    }

  private val timer: Timer = new Timer

  timer.schedule(timerTask, step.toMillis, step.toMillis)

  // Using ListBuffer cause it uses immutable list internally, which allows to eval toList in constant time
  private val performingActions: MutableMap[UUID, ListBuffer[TimeModelAction]] = MutableMap.empty

  private val readyActions: MutableMap[UUID, ListBuffer[Action]] = MutableMap.empty

  /** Start actions evaluation and add actions to map. */
  def schedule(newActions: (UUID, Seq[(Action, Int)])*): Unit =
    for
      (id, actions) <- newActions
      if actions.nonEmpty
    do
      val modelActions = actions.map { case (action, stepsToPerform) =>
        action.start()
        TimeModelAction(action, stepsToPerform)
      }

      this.synchronized {
        performingActions.getOrElseUpdate(id, ListBuffer.empty).appendAll(modelActions)
      }

  def getReadyActions(): Map[UUID, List[Action]] = this.synchronized {
    readyActions.toMap.mapValues(_.toList).toMap
  }
