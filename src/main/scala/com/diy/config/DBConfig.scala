package com.diy.config

import slick.jdbc.PostgresProfile.api._

/**
  * Created by vparashar on 13/06/2017.
  */
trait DBConfig {
  def profile: Database
}

class PostgresDB extends DBConfig {
  override def profile: Database = Database.forConfig("pgdb")
}
