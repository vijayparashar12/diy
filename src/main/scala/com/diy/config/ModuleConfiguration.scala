package com.diy.config

import com.google.inject.{AbstractModule, Scopes, TypeLiteral}
import com.typesafe.config.Config
import slick.jdbc.PostgresProfile.api._

/**
  * Created by vparashar on 13/06/2017.
  */
class ModuleConfiguration extends AbstractModule {
  override def configure(): Unit = {
    bind(new TypeLiteral[DBConfig[Database]]{}).to(classOf[PostgresDB]).in(Scopes.SINGLETON)
    bind(new TypeLiteral[Configuration[Config]]{}).to(classOf[TypesafeConfiguration])
  }
}
