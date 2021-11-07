package baekjoon.dfs_bfs

import java.util.*
import kotlin.math.max

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val (m, n) = br.readLine().split(" ").map { it.toInt() }
    val tomatoes = mutableListOf<MutableList<Int>>()
    repeat(n) {
        tomatoes.add(br.readLine().split(" ").map { it.toInt() }.toMutableList())
    }
    val dx = listOf(1, -1, 0, 0)
    val dy = listOf(0, 0, 1, -1)
    val queue: Queue<Pair<Int, Int>> = LinkedList()
    for (i in 0 until n) {
        for (j in 0 until m) {
            if (tomatoes[i][j] == 1) {
                queue.add(Pair(i, j))
            }
        }
    }
    while (queue.isNotEmpty()) {
        val (y, x) = queue.poll()
        for (i in 0..3) {
            val nx = x + dx[i]
            val ny = y + dy[i]
            if (nx in 0 until m && ny in 0 until n && tomatoes[ny][nx] == 0) {
                queue.add(Pair(ny, nx))
                tomatoes[ny][nx] = tomatoes[y][x] + 1
            }
        }
    }
    bw.write("${getResult(tomatoes, m, n)}")
    br.close()
    bw.close()
}

fun getResult(tomatoes: MutableList<MutableList<Int>>, m: Int, n: Int): Int {
    var result = 0
    for (i in 0 until n) {
        for (j in 0 until m) {
            if (tomatoes[i][j] == 0) return -1
            result = max(result, tomatoes[i][j])
        }
    }
    return result - 1
}
