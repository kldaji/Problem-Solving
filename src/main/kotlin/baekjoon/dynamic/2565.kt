package baekjoon.dynamic

import java.lang.Integer.max

data class ElectricCord(val a: Int, val b: Int)

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().toInt()
    val electricCords = mutableListOf<ElectricCord>()
    repeat(n) {
        val (a, b) = br.readLine().toString().split(" ").map { it.toInt() }
        electricCords.add(ElectricCord(a, b))
    }
    electricCords.sortBy { it.a }
    val dp = Array(n) { 1 }
    for (i in 1 until n) {
        for (j in 0 until i) {
            if (electricCords[i].b > electricCords[j].b) {
                dp[i] = max(dp[i], dp[j] + 1)
            }
        }
    }
    bw.write("${n - dp.maxOf { it }}")
    bw.close()
    br.close()
}