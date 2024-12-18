import java.io.File
import java.util.Collections.emptyList
import kotlin.math.abs

fun main() {
    fun part1(input: List<String>): Int {
        var q1 = 0
        var q2 = 0
        var q3 = 0
        var q4 = 0
        val wide = 101
        val tall = 103
        //val arr2D = List(tall) { IntArray(wide) {0} }

        input.forEach { state ->
            var x = state.substring(state.indexOf('=')+1, state.indexOf(',')).toInt()
            var y = state.substring(state.indexOf(',')+1, state.indexOf(' ')).toInt()
            val v_x = state.substring(state.lastIndexOf('=')+1, state.lastIndexOf(',')).toInt()
            val v_y = state.substring(state.lastIndexOf(',')+1).toInt()
            println("$x $y $v_x $v_y")
            for (second in 1 until 101) {
                println("AFTER #$second")
                x = (wide + x + v_x) % wide
                y = (tall + y + v_y) % tall
//                arr2D[y][x]++
//                for(i in arr2D.indices) {
//                    for(j in arr2D[0].indices) {
//                        print(arr2D[i][j])
//                    }
//                    println()
//                }
//                arr2D[y][x] = 0
            }
//            arr2D[y][x]++
//            for(i in arr2D.indices) {
//                for(j in arr2D[0].indices) {
//                    print(arr2D[i][j])
//                }
//                println()
//            }
            if(x in 0 until wide / 2) {
                if(y in 0 until tall / 2) {
                    q1++
                } else if (y in tall / 2 + 1 until tall) {
                    q3++
                }
            } else if (x in wide / 2 + 1 until wide) {
                if(y in 0 until tall / 2) {
                    q2++
                } else if (y in tall / 2 + 1 until tall) {
                    q4++
                }
            }
        }
        println("$q1 $q2 $q3 $q4")
        return q1*q2*q3*q4
    }

    fun part2(input: List<String>): Int {
        val wide = 101
        val tall = 103
        var ii = 7371
        val file = File("myfile.txt")
        while(ii < 7373) {
            var q1 = 0
            var q2 = 0
            var q3 = 0
            var q4 = 0
            val arr2D = List(tall) { IntArray(wide) {0} }
            println(ii)
            input.forEach { state ->
                var x = state.substring(state.indexOf('=') + 1, state.indexOf(',')).toInt()
                var y = state.substring(state.indexOf(',') + 1, state.indexOf(' ')).toInt()
                val v_x = state.substring(state.lastIndexOf('=') + 1, state.lastIndexOf(',')).toInt()
                val v_y = state.substring(state.lastIndexOf(',') + 1).toInt()
                //println("$x $y $v_x $v_y")
                for (second in 1 until ii) {
                    //println("AFTER #$second")
                    x = (wide + x + v_x) % wide
                    y = (tall + y + v_y) % tall
//                arr2D[y][x]++
//                for(i in arr2D.indices) {
//                    for(j in arr2D[0].indices) {
//                        print(arr2D[i][j])
//                    }
//                    println()
//                }
//                arr2D[y][x] = 0
                }
                arr2D[y][x]++
                if (x in 0 until wide / 2) {
                    if (y in 0 until tall / 2) {
                        q1++
                    } else if (y in tall / 2 + 1 until tall) {
                        q3++
                    }
                } else if (x in wide / 2 + 1 until wide) {
                    if (y in 0 until tall / 2) {
                        q2++
                    } else if (y in tall / 2 + 1 until tall) {
                        q4++
                    }
                }
            }
            file.appendText("$ii\n")
            for (i in arr2D.indices) {
                for (j in arr2D[0].indices) {
                    if (arr2D[i][j] == 0)
                        file.appendText(".")
                    else
                        file.appendText("${arr2D[i][j]}")
                }
                file.appendText("\n")
            }
            file.appendText("\n")

//            if(q1 < 45 || q2 < 45 || q3 < 45 || q4 < 45) {
//                println("$ii $q1 $q2 $q3 $q4")
//            }
            ++ii
        }
        //println("$q1 $q2 $q3 $q4")
        return 0
    }

    // Test if implementation meets criteria from the description, like:
    //check(part1(listOf("test_input")) == 1)

    // Or read a large test input from the `src/Day01_test.txt` file:
//    val testInput = readInput("Day01_test")
//    check(part1(testInput) == 11)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day14")
    //part1(input).println()
    part2(input).println()
}
