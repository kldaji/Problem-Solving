package baekjoon.dynamic

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().toInt()
    val dp = Array(101) { LongArray(10) { 0 } }
    for (i in 1..9) {
        dp[1][i] = 1
    }
    for (i in 2..n) {
        for (j in 0..9) {
            when (j) {
                0 -> dp[i][j] = dp[i - 1][1] % 1000000000
                9 -> dp[i][j] = dp[i - 1][8] % 1000000000
                else -> dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % 1000000000
            }
        }
    }
    val result = dp[n].sum()
    bw.write("${result % 1000000000}")
    bw.close()
    br.close()
}