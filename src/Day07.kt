import java.util.*
import kotlin.math.pow

fun main() {
    fun eval(operands: Stack<Long>, operators: Stack<Char>): Long {
        val calculationStack = Stack<Long>()
        calculationStack.push(operands.pop())
        while(operands.isNotEmpty() || operators.isNotEmpty()) {
            if(operators.pop() == '+') {
                val sum = calculationStack.pop() + operands.peek()
                operands.pop()
                calculationStack.push(sum)
            } else {
                val prod = calculationStack.pop() * operands.peek()
                operands.pop()
                calculationStack.push(prod)
            }
        }
        return calculationStack.peek()
    }
    fun part1(input: List<String>): Long {
        var result = 0L;
        for(equation in input) {
            val target = equation.substring(0, equation.indexOf(':')).trim().toLong()
            val operands = equation.substring(equation.indexOf(' ') + 1).trim().split("\\s+".toRegex()).map{it.toLong()}
//            println(target)
//            println(operands)
//            println((1 shl operands.size - 1))
            for (i in 0 until (1 shl operands.size - 1)){
                val operandStack = Stack<Long>()
                operandStack.addAll(operands.reversed())
                val operators = Stack<Char>()
                    operators.addAll(String.format("%${operands.size - 1}s", Integer.toBinaryString(i)).replace(' ', '0').map { if(it == '0') '+' else '*' }.reversed())
                //println(operators)
                val temp = eval(operandStack, operators)
                //println(temp)
                if (target == temp) {
                    result += temp
                    break
                }
            }
        }
        return result
    }

    fun eval2(operands: Stack<Long>, operators: Stack<Char>): Long {
        val calculationStack = Stack<Long>()
        calculationStack.push(operands.pop())
        while(operands.isNotEmpty() || operators.isNotEmpty()) {
            if(operators.peek() == '+') {
                val sum = calculationStack.pop() + operands.peek()
                operands.pop()
                operators.pop()
                calculationStack.push(sum)
            } else if (operators.peek() == '*'){
                val prod = calculationStack.pop() * operands.peek()
                operands.pop()
                operators.pop()
                calculationStack.push(prod)
            } else {
                val concat = (calculationStack.pop().toString() + operands.peek().toString()).toLong()
                operands.pop()
                operators.pop()
                calculationStack.push(concat)
            }
        }
        return calculationStack.peek()
    }

    fun Int.toBase3(): String {
        var num = this
        val builder = StringBuilder()
        do {
            builder.append((num%3))
            num /= 3
        } while (num > 0)
        return builder.reverse().toString()
    }

    fun part2(input: List<String>): Long {
        var result = 0L;
        for(equation in input) {
            val target = equation.substring(0, equation.indexOf(':')).trim().toLong()
            val operands = equation.substring(equation.indexOf(' ') + 1).trim().split("\\s+".toRegex()).map{it.toLong()}
//            println(target)
//            println(operands)
//            println((1 shl operands.size - 1))

            for (i in 0 until 3.0.pow(operands.size - 1).toInt()){
                val operandStack = Stack<Long>()
                operandStack.addAll(operands.reversed())
                val operators = Stack<Char>()
                //println(i.toBase3())
                operators.addAll(String.format("%${operands.size - 1}s", i.toBase3()).replace(' ', '0').map { if(it == '0') '+' else if(it == '1') '*' else '|' }.reversed())
                //println(operators)
                val temp = eval2(operandStack, operators)
                //println(temp)
                if (target == temp) {
                    result += temp
                    break
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
    val input = readInput("Day07")
    //part1(input).println()
    part2(input).println()
}
