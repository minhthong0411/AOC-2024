import java.util.Collections.emptyList
import kotlin.math.abs

fun main() {
    fun String.toDiskBlock(): MutableList<Int> {
        var block = mutableListOf<Int>()
        var mode = 1
        var count = 0
        for(ch in this) {
            for(i in 0 until ch.digitToInt()) {
                if (mode % 2 == 1) {
                    block.add(count)
                } else {
                    block.add(-1)
                }
            }
            mode += 1
            if(mode % 2 == 1) count += 1
        }
        return block
    }
    fun MutableList<Int>.defragment(): MutableList<Int> {
        val block = this
        var i = 0
        var j = this.lastIndex
        while(i < j) {
            if(block[i] == -1) {
                block[i] = block[j]
                block[j] = -1
                while(block[j] == -1) {
                    --j
                }
            }
            ++i
        }
        return block
    }
    fun MutableList<Int>.checkSum(): ULong {
        var result = 0uL
        forEachIndexed { index, c ->
            if(c != -1) {
                result += (index.toULong() * c.toULong())
            }
        }
        return result
    }
    fun part1(input: List<String>): ULong {
        var result = 0uL;
        for(diskMap in input) {
            //println(diskMap.toDiskBlock())
            //println(diskMap.toDiskBlock().defragment())
            result = diskMap.toDiskBlock().defragment().checkSum()
        }
        return result
    }

    fun part2(input: List<String>): ULong {
        var result = 0uL;
        for(diskMap in input) {
            val originalMap = diskMap.toDiskBlock()
            val block = originalMap.reversed()
            val windows: MutableList<List<Int>> = mutableListOf()
            var temp = listOf<Int>()
            for (i in 0 until block.size - 1) {
                if (block[i] != -1 && block[i] == block[i + 1]) {
                    temp = temp.plus(block[i])
                } else {
                    if (block[i] != -1) {
                        temp = temp.plus(block[i])
                    }
                    if (temp.isNotEmpty()) {
                        windows.add(temp)
                    }
                    temp = listOf()
                }
            }

//            val map = mutableListOf<Int>()
//            map.addAll(originalMap)
//            println(windows)
//            println(originalMap)
//            println(map)

            for(window in windows) {
                //println("WINDOW $window")
                var i = 0
                val idx = originalMap.indexOf(window[0])
                while (i + window.size - 1 < originalMap.size && i < idx) {
                    //println("CURR I: $i")
                    if(originalMap[i] == -1) {
                        var doesFit = true
                        //println("INSIDE " + i + " ${window.size}")
                        for(k in i until i + window.size){
                            //println("k $k ${originalMap[k] == -1}")
                            if(originalMap[k] != -1) {
                                doesFit = false
                                break
                            }
                        }
                        //println("FIT? $doesFit")

                        if(doesFit) {
                            for(k in idx until idx + window.size) {
                                originalMap[k] = -1
                            }
                            for(k in i until i + window.size){
                                originalMap[k] = window[0]
                            }
                            //println(originalMap)
                            //i += window.size
                            //println(i)
                            break
                        } else {
                            ++i
                        }
                    }else {
                        ++i
                    }

//                    var doesFit = true
//                    //println("i: $i")
//                    if (window.size > 1) {
//                        for (j in 0 until window.lastIndex) {
//                            //println("j: $j")
//                            //println("${map[i + j]} ${map[i + j + 1]}")
//                            if (map[i + j] != -1 || map[i + j + 1] != -1) {
//                                doesFit = false
//                                break
//                            }
//                        }
//                    } else {
//                        i = map.indexOf(-1)
//                    }
//                    if (doesFit && i < originalMap.indexOf(window[0])) {
//                        //println("Final i: $i")
//                        for (k in 0 until window.size) {
//                            map[originalMap.indexOf(window[0]) + k] = -1
//                        }
//                        for (k in 0 until window.size) {
//                            map[k + i] = window[k]
//                        }
//                        //println(map)
//                        break
//                    }
               }
            }
            result = originalMap.checkSum()
        }
        return result
    }

    // Test if implementation meets criteria from the description, like:
    //check(part1(listOf("test_input")) == 1)

    // Or read a large test input from the `src/Day01_test.txt` file:
//    val testInput = readInput("Day01_test")
//    check(part1(testInput) == 11)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day09")
    //part1(input).println()
    part2(input).println()
}
