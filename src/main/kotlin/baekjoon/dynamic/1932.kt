package baekjoon.dynamic

import kotlin.math.max

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().toInt()
    val triangleList = mutableListOf<MutableList<Int>>()
    repeat(n) {
        triangleList.add(br.readLine().toString().split(" ").map { it.toInt() }.toMutableList())
    }
    for (i in 1 until n) {
        for (j in 0..i) {
            when (j) {
                0 -> triangleList[i][j] += triangleList[i - 1][j]
                i -> triangleList[i][j] += triangleList[i - 1][j - 1]
                else -> triangleList[i][j] += max(triangleList[i - 1][j - 1], triangleList[i - 1][j])
            }
        }
    }
    bw.write("${triangleList[n - 1].maxOf { it }}")
    bw.close()
    br.close()
}