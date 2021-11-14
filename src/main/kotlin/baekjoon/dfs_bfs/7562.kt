package baekjoon.dfs_bfs

import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val t = br.readLine().toInt()
    val dx = listOf(-2, -1, 1, 2, 2, 1, -1, -2)
    val dy = listOf(1, 2, 2, 1, -1, -2, -2, -1)
    repeat(t) {
        val n = br.readLine().toInt()
        val (srcX, srcY) = br.readLine().split(" ").map { it.toInt() }
        val (destX, destY) = br.readLine().split(" ").map { it.toInt() }
        val queue: Queue<Triple<Int, Int, Int>> = LinkedList()
        val visited = Array(n) { Array(n) { false } }
        queue.add(Triple(srcX, srcY, 0))
        visited[srcY][srcX] = true
        while (queue.isNotEmpty()) {
            val (currX, currY, cnt) = queue.poll()
            if (currX == destX && currY == destY) {
                bw.write("$cnt\n")
                break
            }
            for (i in 0 until 8) {
                val nx = currX + dx[i]
                val ny = currY + dy[i]
                if (nx in 0 until n && ny in 0 until n && !visited[ny][nx]) {
                    queue.add(Triple(nx, ny, cnt + 1))
                    visited[ny][nx] = true
                }
            }
        }
    }
    br.close()
    bw.close()
}
