
# Spark and Cassandra Integration in Scala


<p align="center">
  <img src="https://github.com/Nandhinired/Spark_Cassandra/assets/69593809/2777d5f6-5175-471c-b70c-b0697810faae" width="550" title="Spark-Cassandra Integration">
</p> 


This project demonstrates how to integrate Apache Spark and Apache Cassandra using Scala programming language.

## Dependencies
The following dependencies are required for this project:

    Apache Spark 3.0 or later
    DataStax Cassandra Connector 3.0 or later

## Getting Started
To run the project, follow these steps:

 1.Clone the repository to your local machine.   
 2.Set up a Cassandra cluster and create a keyspace and table.Here's an example of how to create a simple table in Cassandra:

`CREATE KEYSPACE IF NOT EXISTS test
WITH replication = {'class': 'SimpleStrategy', 'replication_factor': '1'};

CREATE TABLE IF NOT EXISTS test.users (
id int PRIMARY KEY,
name text,
age int
);`

 3.Make sure the cluster is reachable from the machine running the Spark application.
 

## Code Structure
src/main/scala/com/example/SparkCassandraIntegration.scala: The main Spark application that integrates with Cassandra and performs some data manipulation.


## Contributing
Contributions are welcome! If you have any ideas or improvements, please submit a pull request or open an issue.

## Acknowledgments
The Apache Spark and Apache Cassandra communities for providing excellent documentation and support.
DataStax for providing the Cassandra Connector for Spark.




