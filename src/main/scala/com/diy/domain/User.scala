package com.diy.domain


import java.util.UUID

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import spray.json.{DefaultJsonProtocol, DeserializationException, JsObject, JsString, JsValue, RootJsonFormat}

case class User(id: Option[UUID] = None, email: String, password: Password)

object UserJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {

  implicit object UserJsonFormat extends RootJsonFormat[User] {
    def write(u: User) = JsObject(
      "id" -> JsString(u.id.getOrElse("UUID").toString),
      "email" -> JsString(u.email) //,
      //"password" -> JsString(u.password.toString)
    )

    def read(value: JsValue) = {
      value.asJsObject.getFields("email", "password") match {
        case Seq(JsString(email), JsString(password)) =>
          new User(email = email, password = Password(password))
        case _ => throw new DeserializationException("User expected")
      }
    }
  }

}







