package baekjoon.greedy

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().toInt()
    val distances = br.readLine().toString().split(" ").map { it.toLong() }
    val gasStations = br.readLine().toString().split(" ").map { it.toLong() }
    var minGas = gasStations[0]
    var total = 0L
    for (i in 0 until n - 1) {
        if (minGas > gasStations[i]) {
            minGas = gasStations[i]
        }
        total += minGas * distances[i]
    }
    bw.write("$total")
    br.close()
    bw.close()
}