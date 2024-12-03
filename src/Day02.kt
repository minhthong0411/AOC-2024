import java.util.Collections.emptyList
import kotlin.math.abs

fun main() {
    fun isDecreasing(report: List<Int>): Boolean {
        for(index in 0 until report.lastIndex) {
            if(report[index] < report[index + 1]) {
                return false
            }
        }
        return true
    }
    fun isIncreasing(report: List<Int>): Boolean {
        for(index in 0 until report.lastIndex) {
            if(report[index] > report[index + 1]) {
                return false
            }
        }
        return true
    }
    fun isSorted(report: List<Int>): Boolean{
        return isIncreasing(report) || isDecreasing(report)
    }
    fun hasCorrectLevelDifferences(report: List<Int>): Boolean {
        for(index in 0 until report.lastIndex) {
            val diff = abs(report[index] - report[index + 1])
            if(diff !in 1..3) {
                return false
            }
        }
        return true
    }
    fun isSafe(report: List<Int>): Boolean {
        return isSorted(report) && hasCorrectLevelDifferences(report)
    }
    fun isSafeWithRemoval(report: List<Int>): Boolean {
        if(isSafe(report)){
            return true
        } else {
            for(index in report.indices){
                if(isSafe(report.filterIndexed { i, _ -> i != index })) {
                    return true
                }
            }
            return false
        }
    }
    fun part1(input: List<String>): Int {
        var result = 0;
        for(report in input){
//            println(isDecreasing(report.split("\\s+".toRegex()).map { it.toInt() }))
//            println(isIncreasing(report.split("\\s+".toRegex()).map { it.toInt() }))
//            println(hasCorrectLevelDifferences(report.split("\\s+".toRegex()).map { it.toInt() }))
//            println(report.split("\\s+".toRegex()).map { it.toInt() })
            if(isSafe(report.split("\\s+".toRegex()).map { it.toInt() })){
                result += 1
            }
        }
        return result
    }

    fun part2(input: List<String>): Int {
        var result = 0;
        for(report in input){
//            println(isDecreasing(report.split("\\s+".toRegex()).map { it.toInt() }))
//            println(isIncreasing(report.split("\\s+".toRegex()).map { it.toInt() }))
//            println(hasCorrectLevelDifferences(report.split("\\s+".toRegex()).map { it.toInt() }))
//            println(report.split("\\s+".toRegex()).map { it.toInt() })
            if(isSafeWithRemoval(report.split("\\s+".toRegex()).map { it.toInt() })){
                result += 1
            }
        }
        return result
    }

    // Test if implementation meets criteria from the description, like:
    //check(part1(listOf("test_input")) == 1)

    // Or read a large test input from the `src/Day01_test.txt` file:
//    val testInput = readInput("Day01_test")
//    check(part1(testInput) == 11)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day02")
    //part1(input).println()
    part2(input).println()
}
