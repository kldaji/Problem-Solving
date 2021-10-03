// 좌표 정렬하기
package baekjoon.sorting

data class Point(val x: Int, val y: Int) {
    override fun toString(): String {
        return "$x $y"
    }
}

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().toInt()
    val pointList = mutableListOf<Point>()
    repeat(n) {
        val (x, y) = br.readLine().split(" ").map { it.toInt() }
        pointList.add(Point(x, y))
    }
    pointList.sortWith(compareBy({ it.x }, { it.y }))
    pointList.forEach {
        bw.write("$it\n")
    }
    br.close()
    bw.close()
}