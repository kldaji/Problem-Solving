package baekjoon.dfs_bfs

import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    // n : 가로, m : 세로
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val graph = mutableListOf<List<Int>>()
    repeat(n) {
        graph.add(br.readLine().split("").filter { it.isNotBlank() }.map { it.toInt() })
    }
    val queue: Queue<Triple<Int, Int, Int>> = LinkedList()
    val visited = Array(n) { Array(m) { Array(2) { 0 } } }
    val dx = listOf(0, 0, 1, -1)
    val dy = listOf(1, -1, 0, 0)
    var result = -1
    queue.add(Triple(0, 0, 1))
    visited[0][0][1] = 1
    while (queue.isNotEmpty()) {
        val (y, x, chance) = queue.poll()
        if (y == n - 1 && x == m - 1) {
            result = visited[y][x][chance]
            break
        }
        for (i in 0..3) {
            val ny = y + dy[i]
            val nx = x + dx[i]
            if (nx in 0 until m && ny in 0 until n) {
                if (graph[ny][nx] == 1 && chance == 1) {
                    queue.add(Triple(ny, nx, 0))
                    visited[ny][nx][0] = visited[y][x][1] + 1
                }
                if (graph[ny][nx] == 0 && visited[ny][nx][chance] == 0) {
                    queue.add(Triple(ny, nx, chance))
                    visited[ny][nx][chance] = visited[y][x][chance] + 1
                }
            }
        }
    }
    bw.write("$result")
    br.close()
    bw.close()
}
