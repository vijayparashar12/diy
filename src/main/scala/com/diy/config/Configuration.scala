package com.diy.config

import com.typesafe.config.{Config, ConfigFactory}

trait Configuration {
}

case class ConfigurationService() extends Configuration {
  lazy val config: Config = ConfigFactory.load(this.getClass().getClassLoader(), "application.conf")
}


