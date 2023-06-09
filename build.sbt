name := "Spark_Cassandra"
version := "0.1"
scalaVersion := "2.12.10"
autoScalaLibrary := false
val sparkVersion = "3.0.0"

val sparkDependencies = Seq(
  "org.apache.spark" %% "spark-core" % sparkVersion,
  "org.apache.spark" %% "spark-sql" % sparkVersion,
  "com.datastax.spark" %% "spark-cassandra-connector" % sparkVersion,
  "com.github.jnr" % "jnr-posix" % "3.0.50",
  "joda-time" % "joda-time" % "2.10.10"
)

libraryDependencies ++= sparkDependencies

