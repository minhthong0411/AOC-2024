import java.util.Collections.emptyList
import kotlin.math.abs

fun main() {
    fun part1(input: List<String>): Int {
        var result = 0;
        var list1 = emptyList<Int>()
        var list2 = emptyList<Int>()
        for(item in input) {
            val pair = item.split("\\s+".toRegex())
            list1 = list1.plus(pair[0].toInt())
            list2 = list2.plus(pair[1].toInt())
        }
        list1.sort()
        list2.sort()
        for(index in list1.indices) {
            result += (abs(list1[index] - list2[index]))
        }
        return result
    }

    fun part2(input: List<String>): Int {
        var result = 0;
        var list1 = emptyList<Int>()
        var list2 = emptyList<Int>()
        for(item in input) {
            val pair = item.split("\\s+".toRegex())
            list1 = list1.plus(pair[0].toInt())
            list2 = list2.plus(pair[1].toInt())
        }
        for(index in list1.indices) {
            result += (list1[index] * list2.filter { it == list1[index] }.size)
        }
        return result
    }

    // Test if implementation meets criteria from the description, like:
    //check(part1(listOf("test_input")) == 1)

    // Or read a large test input from the `src/Day01_test.txt` file:
//    val testInput = readInput("Day01_test")
//    check(part1(testInput) == 11)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day01")
    //part1(input).println()
    part2(input).println()
}
