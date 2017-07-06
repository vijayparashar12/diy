package com.diy.rest

import akka.http.scaladsl.server.Directives._
import com.diy.domain.persistence.UserRepository
import com.google.inject.Inject


/**
  * Not sure if this is correct why but this looks more cleaner to me.
  * Implement a trait with all the routes for specific resource,
  * add that trait here in route value.
  * @param userRepository this is required by userRoutes currently
  */
class ServiceRoutes @Inject()(override val userRepository: UserRepository)
  extends MatrixRoutes
    with UserRoutes {
  val route = matrixRoutes ~ userRoutes
}
