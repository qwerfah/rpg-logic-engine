package com.qwerfah.rpg_logic_engine.engine.action

trait ActionResult[+T]

case object DoNothing extends ActionResult[Nothing]
