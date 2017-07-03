package com.diy.domain.persistence

import com.diy.config.DBConfig
import com.diy.domain.{Password, User}
import com.google.inject.Inject
import slick.jdbc.PostgresProfile.api._
import slick.lifted.{TableQuery, Tag}

import scala.concurrent.Future

/**
  * Created by vparashar on 02/07/2017.
  */
class UserRepository @Inject()(dbConfig: DBConfig) {

  val db = dbConfig.profile

  val userTable = TableQuery[Users]

  def insert(user: User): Future[Int] = db.run {
    userTable += user
  }

  def batchInsert(userList: List[User]) = db.run {
    userTable ++= userList
  }

  def update(user: User) = db.run {
    userTable.filter(_.id === user.id).update(user)
  }

  def getAllUsers() = db.run {
    userTable.result
  }

  def getByEmail(email: String): Future[Option[User]] = db.run {
    userTable.filter(_.email === email).result.headOption
  }

  def getById(id: Long): Future[Option[User]] = db.run {
    userTable.filter(_.id === id).result.headOption
  }

  def batchDelete(emails: Seq[String]) = emails.foreach(delete)

  def delete(email: String): Future[Int] = db.run {
    userTable.filter(_.email === email).delete
  }

  class Users(tag: Tag) extends Table[User](tag, Some("diy"), "users") {
    def * = (id.?, email, password) <> ( { t => User(t._1, t._2, Password(t._3)) }, { user: User => Some(user.id, user.email, user.password.toString) }
    )

    def id = column[Long]("id", O.PrimaryKey, O.AutoInc)

    def email = column[String]("user_email")

    def password = column[String]("user_password")

  }

}
