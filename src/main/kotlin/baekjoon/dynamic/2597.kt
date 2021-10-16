package baekjoon.dynamic

import kotlin.math.max

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().toInt()
    val stepList = mutableListOf<Int>()
    repeat(n) {
        stepList.add(br.readLine().toInt())
    }
    bw.write("${calcMaxStep(stepList)}")
    bw.close()
    br.close()
}

fun calcMaxStep(steps: List<Int>): Int {
    val length = steps.size
    val dp = Array(length) { 0 }
    dp[0] = steps[0]
    if (length == 1) return dp[0]
    dp[1] = dp[0] + steps[1]
    if (length == 2) return dp[1]
    dp[2] = max(steps[0] + steps[2], steps[1] + steps[2])
    if (length == 3) return dp[2]
    for (i in 3 until length) {
        dp[i] = max(dp[i - 3] + steps[i - 1] + steps[i], dp[i - 2] + steps[i])
    }
    return dp[length - 1]
}
