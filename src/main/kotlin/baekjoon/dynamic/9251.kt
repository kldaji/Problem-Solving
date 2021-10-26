package baekjoon.dynamic

import kotlin.math.max

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val word1 = br.readLine().toString()
    val word2 = br.readLine().toString()
    val dp = Array(word1.length + 1) { Array(word2.length + 1) { 0 } }

    for (i in word1.indices) {
        for (j in word2.indices) {
            if (word1[i] == word2[j]) {
                dp[i + 1][j + 1] = dp[i][j] + 1
            } else {
                dp[i + 1][j + 1] = max(dp[i + 1][j], dp[i][j + 1])
            }
        }
    }
    bw.write("${dp[word1.length ][word2.length]}")
    bw.close()
    br.close()
}