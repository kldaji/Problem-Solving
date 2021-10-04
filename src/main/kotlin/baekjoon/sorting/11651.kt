// 좌표 정렬하기 2
package baekjoon.sorting

data class Coordination(val x: Int, val y: Int) {
    override fun toString(): String {
        return "$x $y"
    }
}

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().toInt()
    val pointList = mutableListOf<Coordination>()
    repeat(n) {
        val (x, y) = br.readLine().split(" ").map { it.toInt() }
        pointList.add(Coordination(x, y))
    }
    pointList.sortWith(compareBy({ it.y }, { it.x }))
    pointList.forEach {
        bw.write("$it\n")
    }
    br.close()
    bw.close()
}