import java.io.File
import java.io.FileWriter
import java.io.PrintWriter
import java.util.Collections.emptyList
import java.util.LinkedList
import kotlin.math.abs
import kotlin.math.pow

fun main() {
    fun part1(input: List<String>): Int {
        var queue = LinkedList<ULong>()
        queue.addAll(input[0].split("\\s+".toRegex()).map { it.toULong() })
        for(blinkCount in 0 until 25) {
            val tempQueue = LinkedList<ULong>()
            while(queue.isNotEmpty()) {
                val num = queue.pop()
                if(num == 0uL) {
                    tempQueue.add(1uL)
                } else if (num.toString().length % 2 == 0) {
                    tempQueue.add(num / (10.0.pow(num.toString().length / 2)).toULong())
                    tempQueue.add(num % (10.0.pow(num.toString().length / 2)).toULong())
                } else {
                    tempQueue.add(num * 2024uL)
                }
            }
            queue.addAll(tempQueue)
        }
        return queue.size
    }

    fun part2(input: List<String>): Int {
        var queue = LinkedList<ULong>()
        queue.addAll(input[0].split("\\s+".toRegex()).map { it.toULong() })
        var numOfElement = queue.size
//        val file = File("output.txt")
//        val writer = PrintWriter(FileWriter(file)) // true for append mode
        for(blinkCount in 0 until 75) {
            println("blink count: $blinkCount")
            for(i in 0 until numOfElement) {
                val num = queue.pop()
                if(num == 0uL) {
                    queue.addLast(1uL)
                } else if (num.toString().length % 2 == 0) {
                    queue.addLast(num / (10.0.pow(num.toString().length / 2)).toULong())
                    queue.addLast(num % (10.0.pow(num.toString().length / 2)).toULong())
                } else {
                    queue.addLast(num * 2024uL)
                }
            }
//            PrintWriter("output.txt").use { writer ->
//                writer.print("$blinkCount: ")
//                queue.forEach {
//                    writer.print("$it ")
//                }
//                writer.println()
//            }
            numOfElement = queue.size
        }
        return queue.size
    }

    // Test if implementation meets criteria from the description, like:
    //check(part1(listOf("test_input")) == 1)

    // Or read a large test input from the `src/Day01_test.txt` file:
//    val testInput = readInput("Day01_test")
//    check(part1(testInput) == 11)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day11")
    part1(input).println()
    part2(input).println()
}
