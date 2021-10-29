package baekjoon.greedy

data class Meeting(val start: Int, val end: Int)

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().toInt()
    val meetings = mutableListOf<Meeting>()
    repeat(n) {
        val (s, e) = br.readLine().toString().split(" ").map { it.toInt() }
        meetings.add(Meeting(s, e))
    }
    meetings.sortWith(compareBy({ it.end }, { it.start }))
    var count = 1
    var e = meetings[0].end
    for (i in 1 until n) {
        if (meetings[i].start >= e) {
            e = meetings[i].end
            count++
        }
    }
    bw.write("$count")
    br.close()
    bw.close()
}