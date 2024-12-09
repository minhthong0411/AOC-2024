fun main() {
    fun isSafe(pageOrderingRules: String, hashMap: MutableMap<Int, Pair<List<Int>?, List<Int>?>>): Int {
        val rules = pageOrderingRules.split(",").map { it.toInt() }
        for(i in rules.indices) {
            for(j in rules.indices) {
                if(j < i) {
                    if(hashMap[rules[i]]?.first?.contains(rules[j]) != true) {
                        return -1
                    }
                } else if (j > i) {
                    if(hashMap[rules[i]]?.second?.contains(rules[j]) != true) {
                        return -1
                    }
                }
            }
        }
        return rules[rules.size / 2]
    }

    fun part1(input: List<String>): Int {
        var midPageTotal = 0
        val hashMap: MutableMap<Int, Pair<List<Int>?, List<Int>?>> = hashMapOf()
        for(data in input) {
            if(data.contains('|')) {
                val nums = data.split('|').map { it.toInt() }
                if(hashMap.contains(nums[0])) {
                    hashMap[nums[0]] = Pair(hashMap[nums[0]]?.first, hashMap[nums[0]]?.second?.plus(nums[1]))
                } else {
                    hashMap[nums[0]] = Pair(emptyList(), listOf(nums[1]))
                }
                if(hashMap.contains(nums[1])) {
                    hashMap[nums[1]] = Pair(hashMap[nums[1]]?.first?.plus(nums[0]), hashMap[nums[1]]?.second)
                } else {
                    hashMap[nums[1]] = Pair(listOf(nums[0]), emptyList())
                }
            } else if (data.contains(',')) {
                //println(data + " " + isSafe(data, hashMap))
                val midVal = isSafe(data,hashMap)
                if(midVal > -1){
                    midPageTotal += midVal
                }
            } else {
                println(hashMap)
            }
        }
        return midPageTotal
    }

    fun sort(pageOrderingRules: String, hashMap: MutableMap<Int, Pair<List<Int>?, List<Int>?>>): Int {
        val rules = pageOrderingRules.split(",").map { it.toInt() }.toMutableList()
        for(i in rules.indices) {
            for (j in 0 until rules.size - i - 1) {
                if(hashMap[rules[j]]?.first?.contains(rules[j+1]) == true) {
                    val temp = rules[j]
                    rules[j] = rules[j + 1]
                    rules[j + 1] = temp
                }
            }
        }
        return rules[rules.size / 2]
    }
    fun part2(input: List<String>): Int {
        var midPageTotal = 0
        val hashMap: MutableMap<Int, Pair<List<Int>?, List<Int>?>> = hashMapOf()
        for(data in input) {
            if(data.contains('|')) {
                val nums = data.split('|').map { it.toInt() }
                if(hashMap.contains(nums[0])) {
                    hashMap[nums[0]] = Pair(hashMap[nums[0]]?.first, hashMap[nums[0]]?.second?.plus(nums[1]))
                } else {
                    hashMap[nums[0]] = Pair(emptyList(), listOf(nums[1]))
                }
                if(hashMap.contains(nums[1])) {
                    hashMap[nums[1]] = Pair(hashMap[nums[1]]?.first?.plus(nums[0]), hashMap[nums[1]]?.second)
                } else {
                    hashMap[nums[1]] = Pair(listOf(nums[0]), emptyList())
                }
            } else if (data.contains(',')) {
                //println(data + " " + isSafe(data, hashMap))
                val midVal = isSafe(data,hashMap)
                if(midVal == -1){
                    midPageTotal += sort(data, hashMap)
                }
            } else {
                println(hashMap)
            }
        }
        return midPageTotal
    }

    // Test if implementation meets criteria from the description, like:
    //check(part1(listOf("test_input")) == 1)

    // Or read a large test input from the `src/Day01_test.txt` file:
//    val testInput = readInput("Day01_test")
//    check(part1(testInput) == 11)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day05")
    part1(input).println()
    part2(input).println()
}

