import sbt._
import Keys._

object ScalaRedisProject extends Build
{
  import Resolvers._
  lazy val root = Project("RedisClient", file(".")) settings(coreSettings : _*)

  lazy val commonSettings: Seq[Setting[_]] = Seq(
    organization := "net.dsolve",
    version := "3.4",
    scalaVersion := "2.12.6",
    crossScalaVersions := Seq("2.12.6", "2.12.1"),

    scalacOptions in Compile ++= Seq( "-unchecked", "-feature", "-language:postfixOps", "-deprecation" ),

    resolvers ++= Seq(akkaRepo) ++  Seq(mvnRepo)
  )

  lazy val coreSettings = commonSettings ++ Seq(
    name := "RedisDottyClient",
    libraryDependencies := Seq(
      "junit"             %  "junit"                   % "4.12"      % "test",
      "org.scalatest"     %%  "scalatest"              % "3.0.5" % "test",
      "org.mockito"       %   "mockito-all"           % "2.0.2-beta" % "test",
      "org.specs2"        %%   "specs2-core"             % "4.3.4" % "test",
      "org.specs2"         %%   "specs2-mock"           % "4.3.4" %  "test",
      "ai.grakn" % "redis-mock" % "0.1.6" % "test"
    ),
      

    libraryDependencies += {
      if(scalaVersion.value.startsWith("2.12"))
        "com.typesafe.akka" %% "akka-actor" % "2.5.16"
      else
        "com.typesafe.akka" %% "akka-actor" % "2.5.16"
    },
    parallelExecution in Test := false,
    publishTo <<= version { (v: String) => 
      val nexus = "https://oss.sonatype.org/" 
      if (v.trim.endsWith("SNAPSHOT")) Some("snapshots" at nexus + "content/repositories/snapshots")
      else Some("releases" at nexus + "service/local/staging/deploy/maven2") 
    },
    credentials += Credentials(Path.userHome / ".sbt" / "sonatype.credentials"),
    publishMavenStyle := true,
    publishArtifact in Test := false,
    pomIncludeRepository := { repo => false },
    pomExtra := (
      <url>https://github.com/debasishg/scala-redis</url>
      <licenses>
        <license>
          <name>Apache 2.0 License</name>
          <url>http://www.apache.org/licenses/LICENSE-2.0.html</url>
          <distribution>repo</distribution>
        </license>
      </licenses>
      <scm>
        <url></url>
        <connection></connection>
      </scm>
      <developers>
        <developer>
          <id>depareddy</id>
          <name>depareddy</name>
          <url></url>
        </developer>
      </developers>),
    unmanagedResources in Compile <+= baseDirectory map { _ / "LICENSE" }
  )
}

object Resolvers {
  val akkaRepo = "typesafe repo" at "http://repo.typesafe.com/typesafe/releases/"
  val mvnRepo="central maven" at "https://oss.sonatype.org/content/repositories/releases/"
}
