/**
 * Created by Ivan on 15.12.15.
 */

import org.apache.spark.{SparkContext, SparkConf}
import org.apache.spark.sql.SQLContext
import org.apache.spark.sql.Row;
import org.apache.spark.sql.types.{StructType,StructField,StringType};

object HomeWork_3 extends App {
  val conf = new SparkConf().setAppName("Homework3").setMaster("local")
  val sc =  new SparkContext(conf)
  val sqlContext = new SQLContext(sc)

  val crimes = sc.textFile("SacramentocrimeJanuary2006.csv")
  val schemaString = crimes.first()
  val schema = StructType(schemaString.split(",").map(fieldName => StructField(fieldName, StringType, true)))

  val rowRDD = crimes.map(_.split(",")).map(p => Row(p(0), p(1), p(2).trim, p(3), p(4), p(5), p(6), p(7), p(8)))

  // Apply the schema to the RDD.
  val crimesDataFrame = sqlContext.createDataFrame(rowRDD, schema)

  // Register the DataFrames as a table.
  crimesDataFrame.registerTempTable("crimes")

  // SQL statements can be run by using the sql methods provided by sqlContext.
  val results = sqlContext.sql("SELECT district, COUNT(district) FROM crimes WHERE district != 'district' GROUP BY district")


  // The results of SQL queries are DataFrames and support all the normal RDD operations.
  // The columns of a row in the result can be accessed by field index or by field name.
  results.map(t => "District " + t(0) +": "+ t(1) ).collect().foreach(println)

  sc.stop();
}
