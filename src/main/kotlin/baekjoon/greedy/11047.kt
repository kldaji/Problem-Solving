package baekjoon.greedy

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val (N, K) = br.readLine().toString().split(" ").map { it.toInt() }
    val costs = mutableListOf<Int>()
    repeat(N) {
        costs.add(br.readLine().toInt())
    }
    var cost = K
    var coin = 0
    costs.reversed().forEach {
        if (cost == 0) return@forEach
        coin += (cost / it)
        cost %= it
    }
    bw.write("$coin")
    br.close()
    bw.close()
}