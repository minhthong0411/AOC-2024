fun main() {
    fun checkNorth(char: Char, arr2D: List<CharArray>, i: Int, j: Int, lowerBound: Int, upperBound: Int): Int {
        var count = 0
        when(char) {
            'X' -> {
                if(lowerBound <= i - 3) {
                    if(arr2D[i - 1][j] == 'M') {
                        if (arr2D[i - 2][j] == 'A') {
                            if (arr2D[i - 3][j] == 'S') {
                                count += 1
                            }
                        }
                    }
                }
            }
//            'M' -> {
//                if(lowerBound <= i - 2 && i + 1 < upperBound) {
//                    if(arr2D[i - 1][j] == 'A') {
//                        if (arr2D[i - 2][j] == 'S') {
//                            if (arr2D[i + 1][j] == 'X') {
//                                count += 1
//                            }
//                        }
//                    }
//                }
//            }
//            'A' -> {
//                if(lowerBound <= i - 2 && i + 1 < upperBound) {
//                    if(arr2D[i - 1][j] == 'M') {
//                        if (arr2D[i - 2][j] == 'X') {
//                            if (arr2D[i + 1][j] == 'S') {
//                                count += 1
//                            }
//                        }
//                    }
//                }
//            }
//            'S' -> {
//                if(lowerBound <= i - 3) {
//                    if(arr2D[i - 1][j] == 'A') {
//                        if (arr2D[i - 2][j] == 'M') {
//                            if (arr2D[i - 3][j] == 'X') {
//                                count += 1
//                            }
//                        }
//                    }
//                }
//            }
        }
        return count
    }
    fun checkSouth(char: Char, arr2D: List<CharArray>, i: Int, j: Int, lowerBound: Int, upperBound: Int): Int {
        var count = 0
        when(char) {
            'X' -> {
                if(upperBound > i + 3) {
                    if(arr2D[i + 1][j] == 'M') {
                        if (arr2D[i + 2][j] == 'A') {
                            if (arr2D[i + 3][j] == 'S') {
                                count += 1
                            }
                        }
                    }
                }
            }
//            'M' -> {
//                if(lowerBound <= i - 1 && i + 2 < upperBound) {
//                    if(arr2D[i - 1][j] == 'X') {
//                        if (arr2D[i + 1][j] == 'A') {
//                            if (arr2D[i + 2][j] == 'S') {
//                                count += 1
//                            }
//                        }
//                    }
//                }
//            }
//            'A' -> {
//                if(lowerBound <= i - 1 && i + 2 < upperBound) {
//                    if(arr2D[i - 1][j] == 'S') {
//                        if (arr2D[i + 1][j] == 'M') {
//                            if (arr2D[i + 2][j] == 'X') {
//                                count += 1
//                            }
//                        }
//                    }
//                }
//            }
//            'S' -> {
//                if(upperBound > i + 3) {
//                    if(arr2D[i + 1][j] == 'A') {
//                        if (arr2D[i + 2][j] == 'M') {
//                            if (arr2D[i + 3][j] == 'X') {
//                                count += 1
//                            }
//                        }
//                    }
//                }
//            }
        }
        return count
    }
    fun checkEast(char: Char, arr2D: List<CharArray>, i: Int, j: Int, lowerBound: Int, upperBound: Int): Int {
        var count = 0
        when(char) {
            'X' -> {
                if(upperBound > j + 3) {
                    if(arr2D[i][j + 1] == 'M') {
                        if (arr2D[i][j + 2] == 'A') {
                            if (arr2D[i][j + 3] == 'S') {
                                count += 1
                            }
                        }
                    }
                }
            }
//            'M' -> {
//                if(lowerBound <= j - 1 && j + 2 < upperBound) {
//                    if(arr2D[i][j - 1] == 'X') {
//                        if (arr2D[i][j + 1] == 'A') {
//                            if (arr2D[i][j + 2] == 'S') {
//                                count += 1
//                            }
//                        }
//                    }
//                }
//            }
//            'A' -> {
//                if(lowerBound <= j - 1 && j + 2 < upperBound) {
//                    if(arr2D[i][j - 1] == 'S') {
//                        if (arr2D[i][j + 1] == 'M') {
//                            if (arr2D[i][j + 2] == 'X') {
//                                count += 1
//                            }
//                        }
//                    }
//                }
//            }
//            'S' -> {
//                if(upperBound > j + 3) {
//                    if(arr2D[i][j + 1] == 'A') {
//                        if (arr2D[i][j + 2] == 'M') {
//                            if (arr2D[i][j + 3] == 'X') {
//                                count += 1
//                            }
//                        }
//                    }
//                }
//            }
        }
        return count
    }
    fun checkWest(char: Char, arr2D: List<CharArray>, i: Int, j: Int, lowerBound: Int, upperBound: Int): Int {
        var count = 0
        when(char) {
            'X' -> {
                if(lowerBound <= j - 3) {
                    if(arr2D[i][j - 1] == 'M') {
                        if (arr2D[i][j - 2] == 'A') {
                            if (arr2D[i][j - 3] == 'S') {
                                count += 1
                            }
                        }
                    }
                }
            }
//            'M' -> {
//                if(lowerBound <= j - 2 && j + 1 < upperBound) {
//                    if(arr2D[i][j + 1] == 'X') {
//                        if (arr2D[i][j - 1] == 'A') {
//                            if (arr2D[i][j - 2] == 'S') {
//                                count += 1
//                            }
//                        }
//                    }
//                }
//            }
//            'A' -> {
//                if(lowerBound <= j - 2 && j + 1 < upperBound) {
//                    if(arr2D[i][j - 1] == 'M') {
//                        if (arr2D[i][j - 2] == 'X') {
//                            if (arr2D[i][j + 1] == 'S') {
//                                count += 1
//                            }
//                        }
//                    }
//                }
//            }
//            'S' -> {
//                if(lowerBound <= j - 3) {
//                    if(arr2D[i][j - 1] == 'A') {
//                        if (arr2D[i][j - 2] == 'M') {
//                            if (arr2D[i][j - 3] == 'X') {
//                                count += 1
//                            }
//                        }
//                    }
//                }
//            }
        }
        return count
    }
    fun checkNorthWest(char: Char, arr2D: List<CharArray>, i: Int, j: Int, iMin: Int, iMax: Int, jMin: Int, jMax: Int): Int {
        var count = 0
        when(char) {
            'X' -> {
                if(iMin <= i - 3 && jMin <= j - 3) {
                    if(arr2D[i - 1][j - 1] == 'M') {
                        if (arr2D[i - 2][j - 2] == 'A') {
                            if (arr2D[i - 3][j - 3] == 'S') {
                                count += 1
                            }
                        }
                    }
                }
            }
//            'M' -> {
//                if(iMin <= i - 2 && i + 1 < iMax && jMin <= j - 2 && j + 1 < jMax) {
//                    if(arr2D[i - 1][j - 1] == 'A') {
//                        if (arr2D[i - 2][j - 2] == 'S') {
//                            if (arr2D[i + 1][j + 1] == 'X') {
//                                count += 1
//                            }
//                        }
//                    }
//                }
//            }
//            'A' -> {
//                if(iMin <= i - 2 && i + 1 < iMax && jMin <= j - 2 && j + 1 < jMax) {
//                    if(arr2D[i - 1][j - 1] == 'M') {
//                        if (arr2D[i - 2][j - 2] == 'X') {
//                            if (arr2D[i + 1][j + 1] == 'S') {
//                                count += 1
//                            }
//                        }
//                    }
//                }
//            }
//            'S' -> {
//                if(iMin <= i - 3 && jMin <= j - 3) {
//                    if(arr2D[i - 1][j - 1] == 'A') {
//                        if (arr2D[i - 2][j - 2] == 'M') {
//                            if (arr2D[i - 3][j - 3] == 'X') {
//                                count += 1
//                            }
//                        }
//                    }
//                }
//            }
        }
        return count
    }
    fun checkSouthEast(char: Char, arr2D: List<CharArray>, i: Int, j: Int, iMin: Int, iMax: Int, jMin: Int, jMax: Int): Int {
        var count = 0
        when(char) {
            'X' -> {
                if(iMax > i + 3 && jMax > j + 3) {
                    if(arr2D[i + 1][j + 1] == 'M') {
                        if (arr2D[i + 2][j + 2] == 'A') {
                            if (arr2D[i + 3][j + 3] == 'S') {
                                count += 1
                            }
                        }
                    }
                }
            }
//            'M' -> {
//                if(iMin <= i - 1 && i + 2 < iMax && jMin <= j - 1 && j + 2 < jMax) {
//                    if(arr2D[i - 1][j - 1] == 'X') {
//                        if (arr2D[i + 1][j + 1] == 'A') {
//                            if (arr2D[i + 2][j + 2] == 'S') {
//                                count += 1
//                            }
//                        }
//                    }
//                }
//            }
//            'A' -> {
//                if(iMin <= i - 1 && i + 2 < iMax && jMin <= j - 1 && j + 2 < jMax) {
//                    if(arr2D[i - 1][j - 1] == 'S') {
//                        if (arr2D[i + 1][j + 1] == 'M') {
//                            if (arr2D[i + 2][j + 2] == 'X') {
//                                count += 1
//                            }
//                        }
//                    }
//                }
//            }
//            'S' -> {
//                if(iMax > i + 3 && jMax > j + 3) {
//                    if(arr2D[i + 1][j + 1] == 'A') {
//                        if (arr2D[i + 2][j + 2] == 'M') {
//                            if (arr2D[i + 3][j + 3] == 'X') {
//                                count += 1
//                            }
//                        }
//                    }
//                }
//            }
        }
        return count
    }
    fun checkNorthEast(char: Char, arr2D: List<CharArray>, i: Int, j: Int, iMin: Int, iMax: Int, jMin: Int, jMax: Int): Int {
        var count = 0
        when(char) {
            'X' -> {
                if(iMin <= i - 3 && jMax > j + 3) {
                    if(arr2D[i - 1][j + 1] == 'M') {
                        if (arr2D[i - 2][j + 2] == 'A') {
                            if (arr2D[i - 3][j + 3] == 'S') {
                                count += 1
                            }
                        }
                    }
                }
            }
//            'M' -> {
//                if(iMin <= i - 2 && i + 1 < iMax && jMin <= j - 1 && j + 2 < jMax) {
//                    if(arr2D[i - 1][j + 1] == 'A') {
//                        if (arr2D[i - 2][j + 2] == 'S') {
//                            if (arr2D[i + 1][j - 1] == 'X') {
//                                count += 1
//                            }
//                        }
//                    }
//                }
//            }
//            'A' -> {
//                if(iMin <= i - 2 && i + 1 < iMax && jMin <= j - 1 && j + 2 < jMax) {
//                    if(arr2D[i - 1][j + 1] == 'M') {
//                        if (arr2D[i - 2][j + 2] == 'X') {
//                            if (arr2D[i + 1][j - 1] == 'S') {
//                                count += 1
//                            }
//                        }
//                    }
//                }
//            }
//            'S' -> {
//                if(iMin <= i - 3 && jMax > j + 3) {
//                    if(arr2D[i - 1][j + 1] == 'A') {
//                        if (arr2D[i - 2][j + 2] == 'M') {
//                            if (arr2D[i - 3][j + 3] == 'X') {
//                                count += 1
//                            }
//                        }
//                    }
//                }
//            }
        }
        return count
    }
    fun checkSouthWest(char: Char, arr2D: List<CharArray>, i: Int, j: Int, iMin: Int, iMax: Int, jMin: Int, jMax: Int): Int {
        var count = 0
        when(char) {
            'X' -> {
                if(iMax > i + 3 && jMin <= j - 3) {
                    if(arr2D[i + 1][j - 1] == 'M') {
                        if (arr2D[i + 2][j - 2] == 'A') {
                            if (arr2D[i + 3][j - 3] == 'S') {
                                count += 1
                            }
                        }
                    }
                }
            }
//            'M' -> {
//                if(iMin <= i - 1 && i + 2 < iMax && jMin <= j - 2 && j + 1 < jMax) {
//                    if(arr2D[i - 1][j + 1] == 'X') {
//                        if (arr2D[i + 1][j - 1] == 'A') {
//                            if (arr2D[i + 2][j - 2] == 'S') {
//                                count += 1
//                            }
//                        }
//                    }
//                }
//            }
//            'A' -> {
//                if(iMin <= i - 1 && i + 2 < iMax && jMin <= j - 2 && j + 1 < jMax) {
//                    if(arr2D[i + 1][j - 1] == 'M') {
//                        if (arr2D[i + 2][j - 2] == 'X') {
//                            if (arr2D[i - 1][j + 1] == 'S') {
//                                count += 1
//                            }
//                        }
//                    }
//                }
//            }
//            'S' -> {
//                if(iMax > i + 3 && jMin <= j - 3) {
//                    if(arr2D[i + 1][j - 1] == 'A') {
//                        if (arr2D[i + 2][j - 2] == 'M') {
//                            if (arr2D[i + 3][j - 3] == 'X') {
//                                count += 1
//                            }
//                        }
//                    }
//                }
//            }
        }
        return count
    }

    fun part1(input: List<String>): Int {
        var xmasCount = 0
        val arr2D = List(input.size) { CharArray(input[0].length) { ' '} }
        for(i in input.indices) {
            for(j in input[i].indices) {
                arr2D[i][j] = input[i][j]
            }
        }
//        for(i in input.indices) {
//            for(j in input[i].indices) {
//                print(arr2D[i][j] + " ")
//            }
//            println()
//        }
        val numRows = arr2D.size
        val numCols = arr2D[0].size
        for(i in arr2D.indices) {
            for(j in arr2D[0].indices) {
               xmasCount += checkNorth(arr2D[i][j], arr2D, i, j, 0, numRows)
               xmasCount += checkSouth(arr2D[i][j], arr2D, i, j, 0, numRows)
               xmasCount += checkEast(arr2D[i][j], arr2D, i, j, 0, numCols)
               xmasCount += checkWest(arr2D[i][j], arr2D, i, j, 0, numCols)
               xmasCount += checkNorthWest(arr2D[i][j], arr2D, i, j, 0, numRows, 0, numCols)
               xmasCount += checkSouthEast(arr2D[i][j], arr2D, i, j, 0, numRows, 0, numCols)
               xmasCount += checkNorthEast(arr2D[i][j], arr2D, i, j, 0, numRows, 0, numCols)
               xmasCount += checkSouthWest(arr2D[i][j], arr2D, i, j, 0, numRows, 0, numCols)
            }
        }
        return xmasCount
    }

    fun checkXMAS(char: Char, arr2D: List<CharArray>, i: Int, j: Int, iMin: Int, iMax: Int, jMin: Int, jMax: Int): Int {
        var count = 0
        if(char == 'M') {
            if(i + 2 < iMax && j + 2 < jMax) {
                if((arr2D[i + 2][j] == 'M' && arr2D[i + 1][j + 1] == 'A' && arr2D[i][j + 2] == 'S' && arr2D[i + 2][j + 2] == 'S') ||
                   (arr2D[i][j + 2] == 'M' && arr2D[i + 1][j + 1] == 'A' && arr2D[i + 2][j] == 'S' && arr2D[i + 2][j + 2] == 'S')
                ){
                    count += 1
                }
            }
        }
        if(char == 'S') {
            if(i + 2 < iMax && j + 2 < jMax) {
                if((arr2D[i + 2][j] == 'S' && arr2D[i + 1][j + 1] == 'A' && arr2D[i][j + 2] == 'M' && arr2D[i + 2][j + 2] == 'M') ||
                    (arr2D[i][j + 2] == 'S' && arr2D[i + 1][j + 1] == 'A' && arr2D[i + 2][j] == 'M' && arr2D[i + 2][j + 2] == 'M')
                ){
                    count += 1
                }
            }
        }
        return count
    }

    fun part2(input: List<String>): Int {
        var xmasCount = 0
        val arr2D = List(input.size) { CharArray(input[0].length) { ' '} }
        for(i in input.indices) {
            for(j in input[i].indices) {
                arr2D[i][j] = input[i][j]
            }
        }
//        for(i in input.indices) {
//            for(j in input[i].indices) {
//                print(arr2D[i][j] + " ")
//            }
//            println()
//        }
        val numRows = arr2D.size
        val numCols = arr2D[0].size
        for(i in arr2D.indices) {
            for(j in arr2D[0].indices) {
                xmasCount += checkXMAS(arr2D[i][j], arr2D, i, j, 0, numRows, 0, numCols)
            }
        }
        return xmasCount
    }

    // Test if implementation meets criteria from the description, like:
    //check(part1(listOf("test_input")) == 1)

    // Or read a large test input from the `src/Day01_test.txt` file:
//    val testInput = readInput("Day01_test")
//    check(part1(testInput) == 11)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day04")
    part1(input).println()
    part2(input).println()
}

