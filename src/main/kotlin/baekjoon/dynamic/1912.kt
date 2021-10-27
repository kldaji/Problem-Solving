package baekjoon.dynamic

import kotlin.math.max

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().toInt()
    val numbers = br.readLine().toString().split(" ").map { it.toInt() }
    val dp = Array(n) { 0 }
    dp[0] = numbers[0]
    for (i in 1 until n) {
        dp[i] = max(numbers[i] + dp[i - 1], numbers[i])
    }
    bw.write("${dp.maxOf { it }}")
    bw.close()
    br.close()
}