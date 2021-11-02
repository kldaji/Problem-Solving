package baekjoon.dfs_bfs

fun bfs(graph: Array<MutableList<Int>>, n: Int): Int {
    val queue = mutableListOf<Int>()
    val visited = Array(n + 1) { false }
    queue.add(1)
    visited[1] = true
    while (queue.isNotEmpty()) {
        val peek = queue.removeFirst()
        graph[peek].forEach {
            if (!visited[it]) {
                queue.add(it)
                visited[it] = true
            }
        }
    }
    return visited.filter { it }.size - 1
}

fun dfs(graph: Array<MutableList<Int>>, visited: Array<Boolean>, node: Int): Int {
    visited[node] = true
    graph[node].forEach {
        if (!visited[it]) {
            dfs(graph, visited, it)
        }
    }
    return visited.filter { it }.size - 1
}

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().toInt()
    val m = br.readLine().toInt()
    val graph = Array(n + 1) { mutableListOf<Int>() }
    repeat(m) {
        val (a, b) = br.readLine().toString().split(" ").map { it.toInt() }
        graph[a].add(b)
        graph[b].add(a)
    }

//    bw.write("${dfs(graph, Array(n + 1) { false }, 1)}")
    bw.write("${bfs(graph, n)}")
    br.close()
    bw.close()
}
