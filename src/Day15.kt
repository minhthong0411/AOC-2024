import java.util.Collections.emptyList
import java.util.LinkedList
import kotlin.math.abs

fun main() {
    fun part1(input: List<String>): Int {
        var result = 0;
        val arr2D = mutableListOf<CharArray>()
        var i = 0
        var j = 0
        input.forEachIndexed { idx, str ->
            if(str.contains('#')) {
                if(str.contains('@')){
                    i = idx
                    j = str.indexOf('@')
                    println("START POS: $i $j")
                }
                arr2D.add(str.toCharArray())
            } else {
                if(str.isNotBlank()) {
                    str.forEach { dir ->
                        //println("Move $dir")
                        when(dir) {
                            '^' -> {
                                var indexOfDot = i
                                while(indexOfDot > 1 && arr2D[indexOfDot][j] != '.' && arr2D[indexOfDot][j] != '#') {
                                    indexOfDot--
                                }
                                //println("Index of Dot: $indexOfDot")
                                if(arr2D[indexOfDot][j] == '.') {
                                    for (newIndex in indexOfDot until i) {
                                        if (newIndex != i - 1) {
                                            arr2D[newIndex][j] = arr2D[newIndex + 1][j]
                                        } else {
                                            arr2D[newIndex][j] = '@'
                                            arr2D[i][j] = '.'
                                            i = newIndex
                                        }
                                    }
                                }
                            }
                            'v' -> {
                                var indexOfDot = i
                                while(indexOfDot < arr2D.lastIndex && arr2D[indexOfDot][j] != '.' && arr2D[indexOfDot][j] != '#') {
                                    indexOfDot++
                                }
                                //println("Index of Dot: $indexOfDot")
                                if(arr2D[indexOfDot][j] == '.') {
                                    for (newIndex in indexOfDot downTo i + 1) {
                                        if (newIndex != i + 1) {
                                            arr2D[newIndex][j] = arr2D[newIndex - 1][j]
                                        } else {
                                            arr2D[newIndex][j] = '@'
                                            arr2D[i][j] = '.'
                                            i = newIndex
                                        }
                                    }
                                }
                            }
                            '<' -> {
                                var indexOfDot = j
                                while(indexOfDot > 1 && arr2D[i][indexOfDot] != '.' && arr2D[i][indexOfDot] != '#') {
                                    indexOfDot--
                                }
                                //println("Index of Dot: $indexOfDot")
                                if(arr2D[i][indexOfDot] == '.') {
                                    for (newIndex in indexOfDot until j) {
                                        if (newIndex != j - 1) {
                                            arr2D[i][newIndex] = arr2D[i][newIndex + 1]
                                        } else {
                                            arr2D[i][newIndex] = '@'
                                            arr2D[i][j] = '.'
                                            j = newIndex
                                        }
                                    }
                                }
                            }
                            '>' -> {
                                var indexOfDot = j
                                while(indexOfDot < arr2D[0].lastIndex && arr2D[i][indexOfDot] != '.' && arr2D[i][indexOfDot] != '#') {
                                    indexOfDot++
                                }
                                //println("Index of Dot: $indexOfDot")
                                if(arr2D[i][indexOfDot] == '.') {
                                    for (newIndex in indexOfDot downTo j + 1) {
                                        if (newIndex != j + 1) {
                                            arr2D[i][newIndex] = arr2D[i][newIndex - 1]
                                        } else {
                                            arr2D[i][newIndex] = '@'
                                            arr2D[i][j] = '.'
                                            j = newIndex
                                        }
                                    }
                                }
                            }
                        }
//                        for(ii in arr2D.indices) {
//                            for(jj in arr2D[0].indices) {
//                                print(arr2D[ii][jj])
//                            }
//                            println()
//                        }
                    }
                }
            }
        }
        for(ii in arr2D.indices) {
            for(jj in arr2D[0].indices) {
                if(arr2D[ii][jj] == 'O') {
                    result += (100 * ii + jj)
                }
            }
        }
        return result
    }

    fun part2(input: List<String>): Int {
        var result = 0;
        val arr2D = mutableListOf<MutableList<Char>>()
        var i = 0
        var j = 0
        input.forEachIndexed { idx, str ->
            if(str.contains('#')) {
                var newStr = ""
                str.forEach { ch ->
                    if(ch == '#' || ch == '.') {
                        newStr += "$ch$ch"
                    } else if (ch == 'O') {
                        newStr += "[]"
                    } else {
                        newStr += "@."
                    }
                }
                if(newStr.contains('@')){
                    i = idx
                    j = newStr.indexOf('@')
                    //println("START POS: $i $j")
                }
                arr2D.add(newStr.toMutableList())
            } else {
                if(str.isNotBlank()) {
                    str.forEach { dir ->
                        //println("Move $dir")
                        when(dir) {
                            '^' -> {
                                val visited = mutableSetOf<Pair<Int,Int>>()
                                val queue = LinkedList<Pair<Int,Int>>()
                                queue.add(Pair(i, j))
                                var hitBlock = false
                                while(queue.isNotEmpty() && !hitBlock) {
                                    val pair = queue.pop()
                                    if(pair !in visited) {
                                        visited.add(pair)
                                    }
                                    //println("EXAMINE $pair ${arr2D[pair.first-1][pair.second]}")
                                    if(pair.first - 1 >= 1) {
                                        if (pair.second + 1 < arr2D[0].lastIndex && arr2D[pair.first - 1][pair.second] == '[') {
                                            if (Pair(pair.first - 1, pair.second) !in queue && Pair(
                                                    pair.first - 1,
                                                    pair.second + 1
                                                ) !in queue
                                            ) {
                                                queue.addLast(Pair(pair.first - 1, pair.second))
                                                queue.addLast(Pair(pair.first - 1, pair.second + 1))
                                            }
                                        } else if(pair.second - 1 > 1 && arr2D[pair.first-1][pair.second] == ']') {
                                            if (Pair(pair.first - 1, pair.second) !in queue && Pair(
                                                    pair.first - 1,
                                                    pair.second - 1
                                                ) !in queue
                                            ) {
                                                queue.addLast(Pair(pair.first - 1, pair.second))
                                                queue.addLast(Pair(pair.first - 1, pair.second - 1))
                                            }
                                        } else {
                                            if (arr2D[pair.first-1][pair.second] == '#') {
                                                //println("HIT THE BLOCK")
                                                hitBlock = true
                                            }
                                        }
                                    }else {
                                        if (arr2D[pair.first-1][pair.second] == '#') {
                                            //println("HIT THE EDGE")
                                            hitBlock = true
                                        }
                                    }
//                                    println("QUEUE So far $queue")
//                                    println("Visited so far ${visited.sortedBy { it.first }}}")
                                }
                                //If visited is not empty, move the boxes
                                if(queue.isEmpty() && !hitBlock) {
                                    visited.sortedBy { it.first }.forEach { pair ->
                                        if(arr2D[pair.first][pair.second] == '@') {
                                            i = pair.first - 1
                                            j = pair.second
                                        }
                                        arr2D[pair.first - 1][pair.second] = arr2D[pair.first][pair.second]
                                        arr2D[pair.first][pair.second] = '.'
                                    }
                                }
                            }
                            'v' -> {
                                val visited = mutableSetOf<Pair<Int,Int>>()
                                val queue = LinkedList<Pair<Int,Int>>()
                                queue.add(Pair(i, j))
                                var hitBlock = false
                                while(queue.isNotEmpty() && !hitBlock) {
                                    val pair = queue.pop()
                                    if(pair !in visited) {
                                        visited.add(pair)
                                    }
                                    //println("EXAMINE $pair ${arr2D[pair.first+1][pair.second]}")
                                    if(pair.first + 1 < arr2D[0].lastIndex) {
                                        if (pair.second + 1 < arr2D[0].lastIndex && arr2D[pair.first + 1][pair.second] == '[') {
                                            if (Pair(pair.first + 1, pair.second) !in queue && Pair(
                                                    pair.first + 1,
                                                    pair.second + 1
                                                ) !in queue
                                            ) {
                                                queue.addLast(Pair(pair.first + 1, pair.second))
                                                queue.addLast(Pair(pair.first + 1, pair.second + 1))
                                            }
                                        } else if(pair.second - 1 > 1 && arr2D[pair.first+1][pair.second] == ']') {
                                            if (Pair(pair.first + 1, pair.second) !in queue && Pair(
                                                    pair.first + 1,
                                                    pair.second - 1
                                                ) !in queue
                                            ) {
                                                queue.addLast(Pair(pair.first + 1, pair.second))
                                                queue.addLast(Pair(pair.first + 1, pair.second - 1))
                                            }
                                        } else {
                                            if (arr2D[pair.first+1][pair.second] == '#') {
                                                //println("HIT THE BLOCK")
                                                hitBlock = true
                                            }
                                        }
                                    }else {
                                        if (arr2D[pair.first+1][pair.second] == '#') {
                                           // println("HIT THE EDGE")
                                            hitBlock = true
                                        }
                                    }
//                                    println("QUEUE So far $queue")
//                                    println("Visited so far ${visited.sortedBy { it.first }}}")
                                }
                                //If visited is not empty, move the boxes
                                if(queue.isEmpty() && !hitBlock) {
                                    visited.sortedByDescending { it.first }.forEach { pair ->
                                        if(arr2D[pair.first][pair.second] == '@') {
                                            i = pair.first + 1
                                            j = pair.second
                                        }
                                        arr2D[pair.first + 1][pair.second] = arr2D[pair.first][pair.second]
                                        arr2D[pair.first][pair.second] = '.'
                                    }
                                }
                            }
                            '<' -> {
                                var indexOfDot = j
                                while(indexOfDot > 1 && arr2D[i][indexOfDot] != '.' && arr2D[i][indexOfDot] != '#') {
                                    indexOfDot--
                                }
                                //println("Index of Dot: $indexOfDot")
                                if(arr2D[i][indexOfDot] == '.') {
                                    for (newIndex in indexOfDot until j) {
                                        if (newIndex != j - 1) {
                                            arr2D[i][newIndex] = arr2D[i][newIndex + 1]
                                        } else {
                                            arr2D[i][newIndex] = '@'
                                            arr2D[i][j] = '.'
                                            j = newIndex
                                        }
                                    }
                                }
                            }
                            '>' -> {
                                var indexOfDot = j
                                while(indexOfDot < arr2D[0].lastIndex && arr2D[i][indexOfDot] != '.' && arr2D[i][indexOfDot] != '#') {
                                    indexOfDot++
                                }
                                //println("Index of Dot: $indexOfDot")
                                if(arr2D[i][indexOfDot] == '.') {
                                    for (newIndex in indexOfDot downTo j + 1) {
                                        if (newIndex != j + 1) {
                                            arr2D[i][newIndex] = arr2D[i][newIndex - 1]
                                        } else {
                                            arr2D[i][newIndex] = '@'
                                            arr2D[i][j] = '.'
                                            j = newIndex
                                        }
                                    }
                                }
                            }
                        }
//                        for(ii in arr2D.indices) {
//                            for(jj in arr2D[0].indices) {
//                                print(arr2D[ii][jj])
//                            }
//                            println()
//                        }
                    }
                }
//                else {
//                    for (ii in arr2D.indices) {
//                        for (jj in arr2D[0].indices) {
//                            print(arr2D[ii][jj])
//                        }
//                        println()
//                    }
//                }
            }
        }
        for(ii in arr2D.indices) {
            for(jj in arr2D[0].indices) {
                if(arr2D[ii][jj] == '[') {
                    result += (100 * ii + jj)
                }
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
    val input = readInput("Day15")
    //part1(input).println()
    part2(input).println()
}
