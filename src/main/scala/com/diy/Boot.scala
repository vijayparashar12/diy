package com.diy

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._
import akka.stream.ActorMaterializer
import com.diy.config.{ConfigurationService, ModuleConfiguration}
import com.diy.rest.{MatrixRoutes, UserRoutes}
import com.google.inject.Guice

object Boot extends App {

  implicit val system = ActorSystem("Web_Service")
  implicit val materializer = ActorMaterializer()


  val injector = Guice.createInjector(new ModuleConfiguration)

  var userRoutes = injector.getInstance(classOf[UserRoutes])

  val matrixRoutes = injector.getInstance(classOf[MatrixRoutes])

  val config = injector.getInstance(classOf[ConfigurationService]).config

  val bindingFuture = Http().bindAndHandle(userRoutes.route ~ matrixRoutes.route,
    config.getString("server.interface"),
    config.getInt("server.port"))

  println(s"Server online at http://${config.getString("server.interface")}:${config.getInt("server.port")}/")

}
