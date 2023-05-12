package Spark_Cassandra

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession
import com.datastax.spark.connector
import org.apache.spark.sql.cassandra

object Spark_Cassandra_Integration {

  def main(args: Array[String]): Unit = {

    Logger.getLogger("org").setLevel(Level.ERROR)

    val spark = SparkSession.builder()
      .master("local[3]")
      .appName("Cassandra Read")
      .config("spark.cassandra.connection.host", "localhost")
      .config("spark.cassandra.connection.port", "9042")
      .getOrCreate()


  }
}
