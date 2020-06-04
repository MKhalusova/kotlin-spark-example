@file:JvmName("SimpleApp")
import org.jetbrains.spark.api.*

fun main() {
    val logFile = "/YOUR_SPARK_HOME/README.md" // Change to your Spark Home path
    withSpark {
        spark.read().textFile(logFile).withCached {
            val numAs = filter { it.contains("a") }.count()
            val numBs = filter { it.contains("b") }.count()
            println("Lines with a: $numAs, lines with b: $numBs")
        }
    }
}
