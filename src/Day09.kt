import java.util.Collections.emptyList
import kotlin.math.abs

fun main() {
    fun String.toDiskBlock(): String {
        var block = ""
        var mode = 1
        var count = 0
        for(ch in this) {
            for(i in 0 until ch.digitToInt()) {
                block += if (mode % 2 == 1) {
                    (count % 10).digitToChar()
                } else {
                    '.'
                }
            }
            mode += 1
            if(mode % 2 == 1) count += 1
        }
        return block
    }
    fun String.defragment(): String {
        val block = StringBuilder(this)
        var i = 0
        var j = this.lastIndex
        while(i < j) {
            if(block[i] == '.') {
                block[i] = block[j]
                block[j] = '.'
                --j
                while(block[j] == '.') {
                    --j
                }
            }
            ++i
        }
        return block.toString()
    }
    fun String.checkSum(): Int {
        var result = 0
        forEachIndexed { index, c ->
            if(c != '.') {
                result += (index * c.digitToInt())
            }
        }
        return result
    }
    fun part1(input: List<String>): Int {
        var result = 0;
        for(diskMap in input) {
            println(diskMap.toDiskBlock())
            println(diskMap.toDiskBlock().defragment())
            result = diskMap.toDiskBlock().defragment().checkSum()
        }
        return result
    }

    fun part2(input: List<String>): Int {
        var result = 0;
        return result
    }

    // Test if implementation meets criteria from the description, like:
    //check(part1(listOf("test_input")) == 1)

    // Or read a large test input from the `src/Day01_test.txt` file:
//    val testInput = readInput("Day01_test")
//    check(part1(testInput) == 11)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day09")
    part1(input).println()
    part2(input).println()
}
