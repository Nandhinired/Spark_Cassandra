package Spark_Cassandra

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession
import com.datastax.spark.connector
import org.apache.spark.sql.cassandra
import org.apache.spark.sql.types.{DoubleType, FloatType, IntegerType, StringType, StructField, StructType}

object Spark_Cassandra_Integration {

  def main(args: Array[String]): Unit = {

    Logger.getLogger("org").setLevel(Level.ERROR)

    val spark = SparkSession.builder()
      .master("local[3]")
      .appName("Cassandra Read")
      .config("spark.cassandra.connection.host", "localhost")
      .config("spark.cassandra.connection.port", "9042")
      .getOrCreate()

    val schema = StructType(Array(
      StructField("overall_rank",IntegerType,true),
      StructField("country_or_region",StringType,true),
      StructField("score",FloatType,true),
      StructField("gdp_per_capita",FloatType,true),
      StructField("social_support",FloatType,true),
      StructField("healthy_life_expectancy",FloatType,true),
      StructField("freedom_to_make_life_choices",FloatType,true),
      StructField("generosity",FloatType,true),
      StructField("perceptions_of_corruption",FloatType,true))
    )
    val csvDf = spark.read.format("csv")
      .option("header","true")
      .schema(schema)
      .load("Input/2018.csv")

    //Writing to Cassandra
    csvDf.write
      .format("org.apache.spark.sql.cassandra")
      .option("keyspace", "nankyspace")
      .option("table", "happiness_index")
      .mode("Append")
      .save()

      // Reading from Cassandra

    val cassandraDf = spark.read.format("org.apache.spark.sql.cassandra")
      .option("keyspace", "nankyspace")
      .option("table", "happiness_index")
      .load()

    cassandraDf.show(5)


  }
}
