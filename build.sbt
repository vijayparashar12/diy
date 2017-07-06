name := "DIY"

version := "1.0"

scalaVersion := "2.12.2"

libraryDependencies ++= Seq(
  "com.typesafe.slick" %% "slick" % "3.2.0",
  "org.slf4j" % "slf4j-nop" % "1.6.4",
  "com.typesafe.slick" %% "slick-hikaricp" % "3.2.0"
)

libraryDependencies += "com.typesafe" % "config" % "1.3.1"

libraryDependencies += "org.postgresql" % "postgresql" % "9.4-1200-jdbc41"

//Flyway
flywayUrl := "jdbc:postgresql://localhost:5432/postgres?user=postgres&password=postgres"

flywayUser := "diy"

flywaySchemas := Seq("public")

flywayBaselineOnMigrate := true

//Guice for dependency injection
libraryDependencies += "com.google.inject" % "guice" % "4.1.0"

//Library for password encryption
libraryDependencies += "com.github.t3hnar" %% "scala-bcrypt" % "3.0"


//Library for rest service
libraryDependencies += "io.spray" %%  "spray-json" % "1.3.3"

libraryDependencies +="com.typesafe.akka" %% "akka-http" % "10.0.9"

libraryDependencies +="com.typesafe.akka" %% "akka-http-spray-json" % "10.0.9"

