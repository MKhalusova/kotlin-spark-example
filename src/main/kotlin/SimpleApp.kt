/* SimpleApp.kt */
import org.apache.spark.sql.SparkSession

object SimpleApp {
    fun main(args: Array<String>) {
        val logFile = "/YOUR_SPARK_HOME/README.md" // Change to your Spark's path

        val spark = SparkSession
            .builder()
            .master("local[2]")
            .appName("Simple Application").orCreate

        val logData = spark.read().textFile(logFile).cache()

        val numAs = logData.filter { s: String -> s.contains("a") }.count()
        val numBs: Long = logData.filter { s: String -> s.contains("b") }.count()
        println("Lines with a: $numAs, lines with b: $numBs")
        spark.stop()
    }
}
