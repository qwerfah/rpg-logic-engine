package com.qwerfah.rpg_logic_engine

import com.typesafe.config.Config
import scala.concurrent.duration.Duration

final case class AppSettings(timeStep: Duration = Duration.Zero)

object AppSettings:
  def fromConfig(config: Config): AppSettings =
    AppSettings()
