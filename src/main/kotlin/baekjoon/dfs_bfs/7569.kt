package baekjoon.dfs_bfs

import java.util.*
import kotlin.math.max

fun getResult2(tomatoes: Array<MutableList<MutableList<Int>>>, m: Int, n: Int, h: Int): Int {
    var result = 0
    for (i in 0 until h) {
        for (j in 0 until n) {
            for (k in 0 until m) {
                if (tomatoes[i][j][k] == 0) {
                    return -1
                }
                result = max(result, tomatoes[i][j][k])
            }
        }
    }
    return result - 1
}

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val (m, n, h) = br.readLine().split(" ").map { it.toInt() }

    val dx = listOf(1, -1, 0, 0, 0, 0)
    val dy = listOf(0, 0, 1, -1, 0, 0)
    val dz = listOf(0, 0, 0, 0, 1, -1)

    val tomatoes = Array(h) { mutableListOf<MutableList<Int>>() }
    repeat(h) { z ->
        repeat(n) {
            tomatoes[z].add(br.readLine().split(" ").map { it.toInt() }.toMutableList())
        }
    }
    val queue: Queue<Triple<Int, Int, Int>> = LinkedList()
    for (i in 0 until h) {
        for (j in 0 until n) {
            for (k in 0 until m) {
                if (tomatoes[i][j][k] == 1) {
                    queue.add(Triple(i, j, k))
                }
            }
        }
    }
    while (queue.isNotEmpty()) {
        val (z, y, x) = queue.poll()
        for (i in 0 until 6) {
            val nx = dx[i] + x
            val ny = dy[i] + y
            val nz = dz[i] + z
            if (nz in 0 until h && ny in 0 until n && nx in 0 until m && tomatoes[nz][ny][nx] == 0) {
                tomatoes[nz][ny][nx] = tomatoes[z][y][x] + 1
                queue.add(Triple(nz, ny, nx))
            }
        }
    }
    bw.write("${getResult2(tomatoes, m, n, h)}")
    br.close()
    bw.close()
}
