package com.diy.config

import com.google.inject.{AbstractModule, Scopes}

/**
  * Created by vparashar on 13/06/2017.
  */
class ModuleConfiguration extends AbstractModule {
  override def configure(): Unit = {
    bind(classOf[DBConfig]).to(classOf[PostgresDB]).in(Scopes.SINGLETON)
    bind(classOf[Configuration]).to(classOf[ConfigurationService])
  }
}
