package baekjoon.greedy


fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val expressions = br.readLine().toString().split("-")
    val numbers = mutableListOf<Int>()
    for (exp in expressions) {
        val tempExpressions = exp.split("+")
        numbers.add(tempExpressions.sumOf { it.toInt() })
    }
    var result = numbers[0]
    for (i in 1 until numbers.size) {
        result -= numbers[i]
    }
    bw.write("$result")
    br.close()
    bw.close()
}