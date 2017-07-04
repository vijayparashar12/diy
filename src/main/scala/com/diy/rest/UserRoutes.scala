package com.diy.rest

import akka.http.scaladsl.model.StatusCodes._
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import com.diy.domain.UserJsonProtocol._
import com.diy.domain.persistence.UserRepository
import com.diy.domain.{Password, User}

import scala.util.{Failure, Success}

trait UserRoutes {
  val userRepository: UserRepository

  val userRoutes: Route =
    path("users") {
      get {
        onComplete(
          userRepository.getAllUsers()) {
          case Success(users) => complete(OK, users)
          case Failure(ex) => complete(InternalServerError, s"An error occurred: ${ex.getMessage}")
        }
      }
    } ~
      path("user") {
        post {
          entity(as[User]) { user =>
            val secureUser = user.copy(password = Password.getEncrypted(user.password.toString))
            userRepository.insert(secureUser)
            complete(Created)
          }
        }
      } ~
      path("user" / LongNumber) { (id) =>
        get {
          onComplete(userRepository.getById(id)) {
            case Success(user) => complete(OK, user)
            case Failure(ex) => complete(InternalServerError, s"An error occurred: ${ex.getMessage}")
          }
        }
      }
}
