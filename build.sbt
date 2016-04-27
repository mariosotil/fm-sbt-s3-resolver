name := "fm-sbt-s3-resolver"

organization := "org.riverframework"

version := "0.10.0-SNAPSHOT"

description := "SBT S3 Resolver Plugin"

licenses := Seq("Apache License, Version 2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0.txt"))

homepage := Some(url("https://github.com/mariosotil/sbt-s3-resolver"))

sbtPlugin := true

EclipseKeys.withSource := true

// Don't use the default "target" directory (which is what SBT uses)
EclipseKeys.eclipseOutput := Some(".target")

val amazonSDKVersion = "1.10.73"

libraryDependencies ++= Seq(
  "com.amazonaws" % "aws-java-sdk-s3" % amazonSDKVersion,
  "com.amazonaws" % "aws-java-sdk-sts" % amazonSDKVersion,
  "org.apache.ivy" % "ivy" % "2.3.0"
)

publishMavenStyle := true

publishTo <<= version { (v: String) =>
  val nexus = "https://oss.sonatype.org/"
  if (v.trim.endsWith("SNAPSHOT")) 
    Some("snapshots" at nexus + "content/repositories/snapshots") 
  else
    Some("releases"  at nexus + "service/local/staging/deploy/maven2")
}

publishArtifact in Test := false

pomIncludeRepository := { _ => false }

scalacOptions += "-feature"

pomExtra :=
  <developers>
    <developer>
      <id>tim</id>
      <name>Tim Underwood</name>
      <email>tim@eluvio.com</email>
      <organization>Frugal Mechanic</organization>
      <organizationUrl>http://frugalmechanic.com</organizationUrl>
    </developer>
    <developer>
      <id>mario</id>
      <name>Mario Sotil</name>
      <email>mario.sotil@gmail.com</email>
      <organization>River Framework</organization>
      <organizationUrl>http://riverframework.org</organizationUrl>
    </developer>
  </developers>
  <scm>
      <connection>scm:git:git@github.com:frugalmechanic/sbt-s3-resolver.git</connection>
      <developerConnection>scm:git:git@github.com:frugalmechanic/sbt-s3-resolver.git</developerConnection>
      <url>git@github.com:frugalmechanic/sbt-s3-resolver.git</url>
  </scm>

