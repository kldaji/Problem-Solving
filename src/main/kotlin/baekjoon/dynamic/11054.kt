package baekjoon.dynamic

import kotlin.math.max

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().toInt()
    val sequence = br.readLine().toString().split(" ").map { it.toInt() }
    val dp1 = Array(n) { 1 }
    val dp2 = Array(n) { 1 }
    for (i in 1 until n) {
        for (j in 0 until i) {
            if (sequence[i] > sequence[j]) {
                dp1[i] = max(dp1[i], dp1[j] + 1)
            }
        }
    }
    for (i in (n - 2) downTo 0) {
        for (j in (n - 1) downTo (i + 1)) {
            if (sequence[i] > sequence[j]) {
                dp2[i] = max(dp2[i], dp2[j] + 1)
            }
        }
    }
    bw.write("${dp1.mapIndexed { index, i -> i + dp2[index] }.maxOf { it - 1 }}")
    bw.close()
    br.close()
}