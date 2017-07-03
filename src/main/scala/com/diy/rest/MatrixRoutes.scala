package com.diy.rest

import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.server.Directives.{complete, get, path}
import akka.http.scaladsl.server.Route

/**
  * Created by vparashar on 02/07/2017.
  */
class MatrixRoutes {
  val route: Route =
    path("health") {
      get {
        complete(StatusCodes.OK)
      }
    }

}
