package com.diy.domain

/**
  * Created by vparashar on 01/07/2017.
  */

import com.github.t3hnar.bcrypt.{Password => BcryptUtil}

class Password(secret: String) {
  def validate(userSecret: String): Boolean = userSecret.isBcrypted(secret)

  override def toString = secret
}

object Password {

  def apply(secret: String): Password = new Password(secret)

  def getEncrypted(secret: String) = new Password(secret.bcrypt)
}
