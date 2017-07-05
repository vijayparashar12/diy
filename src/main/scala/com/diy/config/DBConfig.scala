package com.diy.config

import slick.jdbc.PostgresProfile.api._

/**
  * Created by vparashar on 13/06/2017.
  */
trait DBConfig[T] {
  def profile: T
}

class PostgresDB extends DBConfig[Database] {
  override def profile: Database = Database.forConfig("pgdb")
}
