import java.util.Collections.emptyList
import kotlin.math.abs

fun main() {
    fun part1(input: List<String>): Int {
        var result = 0;
        var i = 0
        var a1: Int = 0
        var b1: Int = 0
        var a2: Int = 0
        var b2: Int = 0
        var c1: Int = 0
        var c2: Int = 0
        while(i < input.size) {
            //println(input[i])
            if(i % 4 == 0) {
                val temp = input[i]
                a1 = temp.substring(temp.indexOf('+') + 1, temp.indexOf(',')).toInt()
                a2 = temp.substring(temp.lastIndexOf('+') + 1).toInt()
            } else if(i % 4 == 1) {
                val temp = input[i]
                b1 = temp.substring(temp.indexOf('+') + 1, temp.indexOf(',')).toInt()
                b2 = temp.substring(temp.lastIndexOf('+') + 1).toInt()
            } else if (i % 4 == 2) {
                val temp = input[i]
                c1 = temp.substring(temp.indexOf('=') + 1, temp.indexOf(',')).toInt()
                c2 = temp.substring(temp.lastIndexOf('=') + 1).toInt()
            } else  {
                val d = abs(a1*b2 - a2*b1)
                val d1 = abs(c1*b2 - c2*b1)
                val d2 = abs(a1*c2 - a2*c1)
                //println("$d $d1 $d2")
                if(d1 % d == 0 && d2 % d == 0) {
                    //println("${3*d1/d + d2/d}")
                    result += (3*d1/d + d2/d)
                }
            }
            ++i
        }
        if(i == input.size) {
            val d = abs(a1*b2 - a2*b1)
            val d1 = abs(c1*b2 - c2*b1)
            val d2 = abs(a1*c2 - a2*c1)
            println("$d $d1 $d2")
            if(d1 % d == 0 && d2 % d == 0) {
                //println("${3*d1/d + d2/d}")
                result += (3*d1/d + d2/d)
            }
        }
        return result
    }

    fun part2(input: List<String>): ULong {
        var result = 0uL;
        var i = 0
        var a1 = 0uL
        var b1 = 0uL
        var a2 = 0uL
        var b2 = 0uL
        var c1 = 0uL
        var c2 = 0uL
        while(i < input.size) {
            println(input[i])
            if(i % 4 == 0) {
                val temp = input[i]
                a1 = temp.substring(temp.indexOf('+') + 1, temp.indexOf(',')).toULong()
                a2 = temp.substring(temp.lastIndexOf('+') + 1).toULong()
            } else if(i % 4 == 1) {
                val temp = input[i]
                b1 = temp.substring(temp.indexOf('+') + 1, temp.indexOf(',')).toULong()
                b2 = temp.substring(temp.lastIndexOf('+') + 1).toULong()
            } else if (i % 4 == 2) {
                val temp = input[i]
                c1 = 10000000000000uL + temp.substring(temp.indexOf('=') + 1, temp.indexOf(',')).toULong()
                c2 = 10000000000000uL + temp.substring(temp.lastIndexOf('=') + 1).toULong()
            } else  {
                val d = abs((a1*b2 - a2*b1).toInt()).toULong()
                val d1 = abs((c1*b2 - c2*b1).toLong()).toULong()
                val d2 = abs((a1*c2 - a2*c1).toLong()).toULong()
                println("$d $d1 $d2")
                if(d1 % d == 0uL && d2 % d == 0uL) {
                    println("RESULT ${3uL*(d1/d) + (d2/d)}")
                    result += (3uL*(d1/d) + d2/d)
                }
            }
            ++i
        }
        if(i == input.size) {
            val d = abs((a1*b2 - a2*b1).toInt()).toULong()
            val d1 = abs((c1*b2 - c2*b1).toLong()).toULong()
            val d2 = abs((a1*c2 - a2*c1).toLong()).toULong()
            println("$d $d1 $d2")
            if(d1 % d == 0uL && d2 % d == 0uL) {
                println("RESULT ${3uL*(d1/d) + (d2/d)}")
                result += (3uL*(d1/d) + d2/d)
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
    val input = readInput("Day13")
    //part1(input).println()
    part2(input).println()
}
