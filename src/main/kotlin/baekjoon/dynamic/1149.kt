package baekjoon.dynamic

import kotlin.math.min

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().toInt()
    val houseArray = Array(1001) { Array(3) { 0 } }
    for (i in 0 until n) {
        val (r, g, b) = br.readLine().toString().split(" ").map { it.toInt() }
        houseArray[i][0] = r
        houseArray[i][1] = g
        houseArray[i][2] = b
    }
    val dp = Array(1001) { Array(3) { 0 } }
    dp[0] = houseArray[0].copyOf()
    for (i in 1 until n) {
        dp[i][0] = houseArray[i][0] + min(dp[i - 1][1], dp[i - 1][2])
        dp[i][1] = houseArray[i][1] + min(dp[i - 1][0], dp[i - 1][2])
        dp[i][2] = houseArray[i][2] + min(dp[i - 1][0], dp[i - 1][1])
    }
    bw.write("${dp[n - 1].minOf { it }}")
    bw.close()
    br.close()
}