// 좌표 압축
package baekjoon.sorting

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val pointMap = mutableMapOf<Int, Int>()
    val n = br.readLine().toInt()
    val pointList = br.readLine().toString().split(" ").map { it.toInt() }
    val sortedList = pointList.sorted().distinct()
    for (i in sortedList.indices) {
        pointMap[sortedList[i]] = i
    }
    for (point in pointList) {
        bw.write("${pointMap[point]} ")
    }
    br.close()
    bw.close()
}