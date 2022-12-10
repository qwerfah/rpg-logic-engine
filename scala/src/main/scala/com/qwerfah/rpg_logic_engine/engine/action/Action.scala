package com.qwerfah.rpg_logic_engine.engine.action

import scala.concurrent.Future
import cats.implicits.catsSyntaxOptionId

trait Action:
  def args: ActionArgs

  protected var maybeFuture: Option[Future[ActionResult[_]]] = None

  def start(): Unit =
    maybeFuture = act(args).some

  def result: Future[ActionResult[_]] =
    maybeFuture.getOrElse(Future.successful(DoNothing))

  protected def act(args: ActionArgs): Future[ActionResult[_]] = ???

final case class Move(args: ActionArgs) extends Action

trait Use extends Action

final case class UseItem(args: ActionArgs) extends Use

final case class UseAbility(args: ActionArgs) extends Use

final case class Attak(args: ActionArgs) extends Action
