import java.util.LinkedList

fun main() {
    fun BFS(arr2D: List<String>, startI: Int, startJ: Int): Int {
        var count = 0
        val visited = mutableSetOf<Pair<Int, Int>>()
        val queue = LinkedList<Pair<Int, Int>>()
        queue.add(Pair(startI, startJ))
        val rows = arr2D.size
        val cols = arr2D[0].length
        while(queue.isNotEmpty()) {
            //println(queue)
            //println(visited)
            val vertex = queue.removeFirst()
            //println("Vertex $vertex")
            if(vertex !in visited) {
                visited.add(vertex)
                if(arr2D[vertex.first][vertex.second] == '9'){
                    count += 1
                }
                val i = vertex.first
                val j = vertex.second
                if(0 <= i - 1){
                    val temp1 = Pair(i-1, j)
                    if(temp1 !in visited && arr2D[i-1][j].digitToInt() == arr2D[i][j].digitToInt() + 1){
                        queue.add(temp1)
                    }
                }
                if(i + 1 < rows) {
                    val temp2 = Pair(i+1, j)
                    if(temp2 !in visited && arr2D[i+1][j].digitToInt() == arr2D[i][j].digitToInt() + 1){
                        queue.add(temp2)
                    }
                }
                if(0 <= j - 1){
                    val temp1 = Pair(i, j-1)
                    if(temp1 !in visited && arr2D[i][j-1].digitToInt() == arr2D[i][j].digitToInt() + 1){
                        queue.add(temp1)
                    }
                }
                if(j + 1 < cols) {
                    val temp2 = Pair(i, j+1)
                    if(temp2 !in visited && arr2D[i][j+1].digitToInt() == arr2D[i][j].digitToInt() + 1){
                        queue.add(temp2)
                    }
                }
            }
        }
        return count
    }
    fun part1(input: List<String>): Int {
        var result = 0;
        val arr2D = List(input.size) { CharArray(input[0].length) {' '} }
        for(i in input.indices) {
            for(j in input[i].indices) {
                if(input[i][j] == '0') {
                    result += BFS(input, i, j)
                } else {
                    continue
                }
            }
        }
        return result
    }
    fun BFS2(arr2D: List<String>, startI: Int, startJ: Int): Int {
        var count = 0
        val visited = mutableSetOf<Pair<Int, Int>>()
        val queue = LinkedList<Pair<Int, Int>>()
        queue.add(Pair(startI, startJ))
        val rows = arr2D.size
        val cols = arr2D[0].length
        while(queue.isNotEmpty()) {
            //println(queue)
            //println(visited)
            val vertex = queue.removeFirst()
            //println("Vertex $vertex")
            if(vertex !in visited) {
                visited.add(vertex)
                if(arr2D[vertex.first][vertex.second] == '9'){
                    count += 1
                }
                val i = vertex.first
                val j = vertex.second
                if(0 <= i - 1){
                    val temp1 = Pair(i-1, j)
                    if(temp1 !in visited && arr2D[i-1][j].digitToInt() == arr2D[i][j].digitToInt() + 1){
                        queue.add(temp1)
                    }
                }
                if(i + 1 < rows) {
                    val temp2 = Pair(i+1, j)
                    if(temp2 !in visited && arr2D[i+1][j].digitToInt() == arr2D[i][j].digitToInt() + 1){
                        queue.add(temp2)
                    }
                }
                if(0 <= j - 1){
                    val temp1 = Pair(i, j-1)
                    if(temp1 !in visited && arr2D[i][j-1].digitToInt() == arr2D[i][j].digitToInt() + 1){
                        queue.add(temp1)
                    }
                }
                if(j + 1 < cols) {
                    val temp2 = Pair(i, j+1)
                    if(temp2 !in visited && arr2D[i][j+1].digitToInt() == arr2D[i][j].digitToInt() + 1){
                        queue.add(temp2)
                    }
                }
            }
        }
        return count
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
    val input = readInput("Day10")
    part1(input).println()
    part2(input).println()
}
