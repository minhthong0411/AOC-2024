import java.util.Collections.emptyList
import kotlin.math.abs

fun main() {
    fun multiply(expr: String): Int {
        val firstNum = expr.substring(expr.indexOf('(') + 1, expr.indexOf(',')).toInt()
        val secondNum = expr.substring(expr.indexOf(',') + 1, expr.indexOf(')')).toInt()
        return firstNum * secondNum
    }
    fun part1(input: List<String>): Int {
        var result = 0
        for(corruptedMessage in input) {
            val regex = Regex("mul\\(\\d+,\\d+\\)")
            //println(regex.findAll(corruptedMessage).toList().map { it.value })
            result += regex.findAll(corruptedMessage).toList().map { it.value }.sumOf { mul -> multiply(mul) }
        }
        return result
    }

    fun part2(input: List<String>): Int {
        var result = 0
        println(input.size)
        var isEnabled = true
        val regex = Regex("mul\\(\\d{1,3},\\d{1,3}\\)|don\'t\\(\\)|do\\(\\)")
        for(corruptedMessage in input) {
            //println(regex.findAll(corruptedMessage).toList().map { it.value })
            val tokens = regex.findAll(corruptedMessage).toList().map { it.value }
            for(token in tokens) {
                if(token == "don't()"){
                    isEnabled = false
                }else if(token == "do()") {
                    isEnabled = true
                }else  {
                    if(isEnabled)
                        result += multiply(token)
                }
            }
//            println("Tokens: ${tokens.size}")
//            println("DO: $countDo")
//            println("DONT: $countDont")
//            println("ENABLED: ${enabled.size}")

        }
        return result
    }

    // Test if implementation meets criteria from the description, like:
    //check(part1(listOf("test_input")) == 1)

    // Or read a large test input from the `src/Day01_test.txt` file:
//    val testInput = readInput("Day01_test")
//    check(part1(testInput) == 11)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day03")
    //part1(input).println()
    part2(input).println()
}
