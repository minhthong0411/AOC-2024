fun main() {
    fun part1(input: List<String>): Int {
        var stepCount = 1
        val arr2D = List(input.size) { CharArray(input[0].length) { ' ' } }
        var pos_i = 0
        var pos_j= 0
        for(i in input.indices) {
            for(j in input[i].indices) {
                arr2D[i][j] = input[i][j]
                if(input[i][j] == '^'){
                    pos_i = i
                    pos_j = j
                }
            }
        }
//        for(i in input.indices) {
//            for(j in input[i].indices) {
//                print(arr2D[i][j] + " ")
//            }
//            println()
//        }
        var direction = '^'
        while(pos_i in 1 until arr2D.lastIndex && pos_j in 1 until arr2D[0].lastIndex) {
            when(direction){
                '^' -> {
                    if(arr2D[pos_i-1][pos_j] == '#'){
                        direction = '>'
                    } else {
                        pos_i -= 1
                    }
                }
                '>' -> {
                    if(arr2D[pos_i][pos_j+1] == '#'){
                        direction = 'v'
                    } else {
                        pos_j += 1
                    }
                }
                'v' -> {
                    if(arr2D[pos_i+1][pos_j] == '#'){
                        direction = '<'
                    } else {
                        pos_i += 1
                    }
                }
                '<' -> {
                    if(arr2D[pos_i][pos_j-1] == '#'){
                        direction = '^'
                    } else {
                        pos_j -= 1
                    }
                }
            }
            if(arr2D[pos_i][pos_j] == '.') {
                stepCount += 1
                arr2D[pos_i][pos_j] = 'X'
            }
        }
        return stepCount
    }
    fun part2(input: List<String>): Int {
        var patrolPositions: List<Pair<Int, Int>> = listOf()
        var loopCount = 0
        var stepCount = 1
        val arr2D = List(input.size) { CharArray(input[0].length) { ' ' } }
        var start_i = 0
        var start_j = 0
        var pos_i = 0
        var pos_j = 0
        for (i in input.indices) {
            for (j in input[i].indices) {
                arr2D[i][j] = input[i][j]
                if (input[i][j] == '^') {
                    pos_i = i
                    pos_j = j
                    start_i = i
                    start_j = j
                }
            }
        }
        patrolPositions = patrolPositions.plus(Pair(pos_i, pos_j))
        var direction = '^'
        while (pos_i in 1 until arr2D.lastIndex && pos_j in 1 until arr2D[0].lastIndex) {
            when (direction) {
                '^' -> {
                    if (arr2D[pos_i - 1][pos_j] == '#') {
                        direction = '>'
                    } else {
                        pos_i -= 1
                    }
                }

                '>' -> {
                    if (arr2D[pos_i][pos_j + 1] == '#') {
                        direction = 'v'
                    } else {
                        pos_j += 1
                    }
                }

                'v' -> {
                    if (arr2D[pos_i + 1][pos_j] == '#') {
                        direction = '<'
                    } else {
                        pos_i += 1
                    }
                }

                '<' -> {
                    if (arr2D[pos_i][pos_j - 1] == '#') {
                        direction = '^'
                    } else {
                        pos_j -= 1
                    }
                }
            }
            if (arr2D[pos_i][pos_j] == '.') {
                stepCount += 1
                arr2D[pos_i][pos_j] = 'X'
                patrolPositions = patrolPositions.plus(Pair(pos_i, pos_j))
            }
        }
//        for(i in input.indices) {
//            for(j in input[i].indices) {
//                arr2D[i][j] = input[i][j]
//                if(input[i][j] == 'X'){
//                    arr2D[i][j] = '.'
//                }
//            }
//        }
        //patrolPositions = listOf(Pair(24,56))
        //println(patrolPositions.size)
        for(i in input.indices) {
            for(j in input[i].indices) {
                //arr2D[i][j] = input[i][j]
                if(arr2D[i][j] == 'X' || arr2D[i][j] == '|' || arr2D[i][j] == '+' || arr2D[i][j] == '-'){
                    arr2D[i][j] = '.'
                }
            }
        }
        for(position in patrolPositions) {
            direction = '^'
            arr2D[position.first][position.second] = 'O'
            pos_i = start_i
            pos_j = start_j
//            for(i in input.indices) {
//                for(j in input[i].indices) {
//                    print(arr2D[i][j])
//                }
//                println()
//            }
//            println()
            val turnPositions = mutableListOf<Pair<Int,Int>>()
            var hitOMoreThanOnce = 0
            //println("TESTING POSITION: ${position.first} ${position.second}")
            while(pos_i in 1 until arr2D.lastIndex && pos_j in 1 until arr2D[0].lastIndex && hitOMoreThanOnce < patrolPositions.size) {
                //println("i $pos_i ${pos_i in 1 until arr2D.lastIndex} j $pos_j ${pos_j in 1 until arr2D[0].lastIndex} moreThanone $hitOMoreThanOnce O_pos ${position.first} ${position.second}")
                when (direction) {
                    '^' -> {
                        if (arr2D[pos_i - 1][pos_j] == '#' || arr2D[pos_i - 1][pos_j] == 'O') {
                            if (Pair(pos_i, pos_j) !in turnPositions) {
                                turnPositions.add(Pair(pos_i, pos_j))
                            } else {
                                hitOMoreThanOnce += 1
                            }
                            direction = '>'
                            //arr2D[pos_i][pos_j] = '+'
                        } else {
                            pos_i -= 1
                            //arr2D[pos_i][pos_j] = '|'
                        }
                    }

                    '>' -> {
                        if (arr2D[pos_i][pos_j + 1] == '#' || arr2D[pos_i][pos_j + 1] == 'O') {
                            if (Pair(pos_i, pos_j) !in turnPositions) {
                                turnPositions.add(Pair(pos_i, pos_j))
                            } else {
                                hitOMoreThanOnce += 1
                            }
                            direction = 'v'
                            //arr2D[pos_i][pos_j] = '+'
                        } else {
                            pos_j += 1
                            //arr2D[pos_i][pos_j] = '-'
                        }
                    }

                    'v' -> {
                        if (arr2D[pos_i + 1][pos_j] == '#' || arr2D[pos_i + 1][pos_j] == 'O') {
                            if (Pair(pos_i, pos_j) !in turnPositions) {
                                turnPositions.add(Pair(pos_i, pos_j))
                            } else {
                                hitOMoreThanOnce += 1
                            }
                            direction = '<'
                            //arr2D[pos_i][pos_j] = '+'
                        } else {
                            pos_i += 1
                            //arr2D[pos_i][pos_j] = '|'
                        }
                    }

                    '<' -> {
                        if (arr2D[pos_i][pos_j - 1] == '#' || arr2D[pos_i][pos_j - 1] == 'O') {
                            if (Pair(pos_i, pos_j) !in turnPositions) {
                                turnPositions.add(Pair(pos_i, pos_j))
                            } else {
                                hitOMoreThanOnce += 1
                            }
                            direction = '^'
                            //arr2D[pos_i][pos_j] = '+'
                        } else {
                            pos_j -= 1
                            //arr2D[pos_i][pos_j] = '-'
                        }
                    }
                }
//                for(i in input.indices) {
//                    for(j in input[i].indices) {
//                        print(arr2D[i][j] + " ")
//                    }
//                    println()
//                }
//                println()
            }
//            println("i $pos_i ${pos_i in 1 until arr2D.lastIndex} j $pos_j ${pos_j in 1 until arr2D[0].lastIndex} moreThanone $hitOMoreThanOnce")
            if(hitOMoreThanOnce > turnPositions.size) {
                loopCount += 1
//                for(i in input.indices) {
//                    for(j in input[i].indices) {
//                        print(arr2D[i][j] + " ")
//                    }
//                    println()
//                }
//                println()
            }
            arr2D[position.first][position.second] = '.'
        }
        return loopCount
    }

    // Test if implementation meets criteria from the description, like:
    //check(part1(listOf("test_input")) == 1)

    // Or read a large test input from the `src/Day01_test.txt` file:
//    val testInput = readInput("Day01_test")
//    check(part1(testInput) == 11)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day06")
    part1(input).println()
    part2(input).println()
}