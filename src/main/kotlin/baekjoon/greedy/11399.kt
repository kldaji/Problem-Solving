package baekjoon.greedy

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().toInt()
    val humans = br.readLine().toString().split(" ").map { it.toInt() }.sorted()
    var result = 0
    for (i in humans.indices) {
        val subHumanList = humans.subList(0, i + 1)
        result = subHumanList.fold(result) { total, time -> total + time }
    }
    bw.write("$result")
    br.close()
    bw.close()
}