package baekjoon.dfs_bfs

data class Point(val x: Int, val y: Int)

fun bfs(n: Int, m: Int, maze: MutableList<List<Int>>): Int {
    val dx = listOf(1, -1, 0, 0)
    val dy = listOf(0, 0, 1, -1)
    val queue = mutableListOf<Point>()
    queue.add(Point(0, 0))
    val visited = Array(n) { Array(m) { 0 } }
    visited[0][0] = 1

    while (queue.isNotEmpty()) {
        val point = queue.removeFirst()
        for (i in 0..3) {
            val nx = point.x + dx[i]
            val ny = point.y + dy[i]
            if (nx in 0 until m && ny in 0 until n && visited[ny][nx] == 0 && maze[ny][nx] == 1) {
                visited[ny][nx] = visited[point.y][point.x] + 1
                queue.add(Point(nx, ny))
            }
        }
    }
    return visited[n - 1][m - 1]
}

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val maze = mutableListOf<List<Int>>()
    repeat(n) {
        maze.add(br.readLine().split("").filter { it.isNotBlank() }.map { it.toInt() })
    }
    bw.write("${bfs(n, m, maze)}")
    br.close()
    bw.close()
}
