package baekjoon.dfs_bfs

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
    val queue = mutableListOf<Pair<Int, Int>>()
    val visited = Array(n) { Array(m) { false } }
    for (i in 0 until n) {
        for (j in 0 until m) {
            if (tomatoes[i][j] == 1) {
                queue.add(Pair(i, j))
            }
        }
    }
    while (queue.isNotEmpty()) {
        val (y, x) = queue.removeFirst()
        visited[y][x] = true
        for (i in 0..3) {
            val nx = x + dx[i]
            val ny = y + dy[i]
            if (nx in 0 until m && ny in 0 until n && !visited[ny][nx] && tomatoes[ny][nx] == 0) {
                visited[ny][nx] = true
                queue.add(Pair(ny, nx))
                tomatoes[ny][nx] = tomatoes[y][x] + 1
            }
        }
    }
    var flag = false
    tomatoes.forEach {
        if (it.contains(0)) {
            flag = true
            return@forEach
        }
    }
    if (!flag) {
        bw.write("${tomatoes.maxOf { list -> list.maxOf { it } } - 1}")
    } else {
        bw.write("-1")
    }
    br.close()
    bw.close()
}
