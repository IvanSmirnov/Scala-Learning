/**
 * Created by Ivan on 15.12.15.
 */
import java.util.concurrent.ThreadLocalRandom

import org.apache.spark.{SparkContext, SparkConf}
import org.apache.spark.mllib.clustering.KMeans
import org.apache.spark.mllib.linalg.Vectors

object HomeWork4  extends App {
  def makeData(points: Int, min: Int, max: Int) = {
    for (i <- 0 until points)
    yield (
      ThreadLocalRandom.current().nextDouble(min, max + 1),
      ThreadLocalRandom.current().nextDouble(min, max + 1)
      )
  }

  val testData = makeData(500, 0, 100)
  testData take 5 foreach println
  val conf = new SparkConf().setAppName("Homework4").setMaster("local")
  val sc =  new SparkContext(conf)

  val rdd = sc.parallelize( testData.map(d => Vectors.dense(d._1, d._2)) ).cache()

  val numClusters = 2
  val numIterations = 20
  val clusters = KMeans.train(rdd, numClusters, numIterations)

  // Evaluate clustering by computing Within Set Sum of Squared Errors
  println("Within Set Sum of Squared Errors = " + clusters.computeCost(rdd))
  println("Cluster Centers: "+ clusters.clusterCenters.apply(0)+clusters.clusterCenters.apply(1) )

  sc.stop()
}