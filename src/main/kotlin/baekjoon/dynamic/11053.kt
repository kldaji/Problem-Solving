package baekjoon.dynamic

import kotlin.math.max

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().toInt()
    val sequence = br.readLine().toString().split(" ").map { it.toInt() }
    val dp = Array(n) { 1 }
    for (i in 1 until n) {
        for (j in 0 until i) {
            if (sequence[i] > sequence[j]) {
                dp[i] = max(dp[i], dp[j] + 1)
            }
        }
    }
    bw.write("${dp.maxOf { it }}")
    bw.close()
    br.close()
}