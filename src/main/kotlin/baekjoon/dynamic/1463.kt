package baekjoon.dynamic

import kotlin.math.min

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().toInt()
    val dp = IntArray(n + 1) { Int.MAX_VALUE }
    dp[n] = 0
    for (i in n downTo 1) {
        if (i % 2 == 0) {
            dp[i / 2] = min(dp[i / 2], dp[i] + 1)
        }
        if (i % 3 == 0) {
            dp[i / 3] = min(dp[i / 3], dp[i] + 1)
        }
        dp[i - 1] = min(dp[i - 1], dp[i] + 1)
    }
    bw.write("${dp[1]}")
    bw.close()
    br.close()
}