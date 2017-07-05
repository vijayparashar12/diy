package com.diy.config

import com.typesafe.config.{Config, ConfigFactory}

trait Configuration[T] {
  def config: T
}

case class TypesafeConfiguration() extends Configuration[Config] {

  lazy val configuration: Config = ConfigFactory.load(this.getClass().getClassLoader(), "application.conf")

  override def config: Config = configuration
}


