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
