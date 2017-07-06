package com.diy

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer
import com.diy.config.{TypesafeConfiguration, ModuleConfiguration}
import com.diy.rest.ServiceRoutes
import com.google.inject.Guice

object Boot extends App {

  implicit val system = ActorSystem("Web_Service")
  implicit val materializer = ActorMaterializer()


  val injector = Guice.createInjector(new ModuleConfiguration)

  var route = injector.getInstance(classOf[ServiceRoutes]).route

  val config = injector.getInstance(classOf[TypesafeConfiguration]).config

  val bindingFuture = Http().bindAndHandle(route,
    config.getString("server.interface"),
    config.getInt("server.port"))

  println(s"Server online at http://${config.getString("server.interface")}:${config.getInt("server.port")}/")

}
