package baekjoon.dfs_bfs

import java.util.*

fun isBipartite(graph: Array<MutableList<Int>>, visited: Array<Boolean>, color: Array<Boolean>, start: Int): Boolean {
    val queue: Queue<Int> = LinkedList()
    queue.add(start)
    while (queue.isNotEmpty()) {
        val curr = queue.poll()
        for (node in graph[curr]) {
            if (visited[node] && color[curr] == color[node]) {
                return false
            }
            if (!visited[node]) {
                queue.add(node)
                visited[node] = true
                color[node] = !color[curr]
            }
        }
    }
    return true
}

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val t = br.readLine().toInt()
    repeat(t) {
        val (v, e) = br.readLine().split(" ").map { it.toInt() }
        val graph = Array(v + 1) { mutableListOf<Int>() }
        repeat(e) {
            val (src, dest) = br.readLine().split(" ").map { it.toInt() }
            graph[src].add(dest)
            graph[dest].add(src)
        }
        val visited = Array(v + 1) { false }
        val color = Array(v + 1) { false }
        var result = "YES"
        for (i in 1 until v + 1) {
            if (!visited[i] && !isBipartite(graph, visited, color,i)) {
                result = "NO"
                break
            }
        }
        bw.write("$result\n")
    }
    br.close()
    bw.close()
}
