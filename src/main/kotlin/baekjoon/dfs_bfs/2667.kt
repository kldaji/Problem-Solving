package baekjoon.dfs_bfs

val dx = listOf(0, 1, 0, -1)
val dy = listOf(1, 0, -1, 0)

fun dfs(graph: MutableList<List<String>>, visited: Array<Array<Boolean>>, x: Int, y: Int, n: Int): Int {
    visited[x][y] = true
    var count = 1
    for (i in 0 until 4) {
        val nx = x + dx[i]
        val ny = y + dy[i]
        if (nx in (0 until n) && ny in (0 until n) && !visited[nx][ny] && graph[nx][ny] == "1") {
            count += dfs(graph, visited, nx, ny, n)
        }
    }
    return count
}

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().toInt()
    val graph = mutableListOf<List<String>>()
    repeat(n) {
        val houses = br.readLine().toString().split("").filter { it.isNotBlank() }
        graph.add(houses)
    }
    val visited = Array(n + 1) { Array(n + 1) { false } }
    val answer = mutableListOf<Int>()
    for (i in 0 until n) {
        for (j in 0 until n) {
            if (!visited[i][j] && graph[i][j] == "1") {
                answer.add(dfs(graph, visited, i, j, n))
            }
        }
    }
    bw.write("${answer.size}\n")
    answer.sort()
    answer.forEach {
        bw.write("$it\n")
    }
    br.close()
    bw.close()
}
