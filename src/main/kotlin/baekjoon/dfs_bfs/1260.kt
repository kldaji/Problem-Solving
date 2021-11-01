package baekjoon.dfs_bfs

import java.io.BufferedWriter

fun dfs(graph: Array<MutableList<Int>>, start: Int, bw: BufferedWriter, n: Int) {
    graph.forEach {
        it.sortDescending()
    }
    val visited = Array(n + 1) { false }
    val stack = mutableListOf<Int>()
    stack.add(start)
    bw.write("$start ")
    visited[start] = true
    while (stack.isNotEmpty()) {
        val top = stack.removeLast()
        if (!visited[top]) {
            bw.write("$top ")
            visited[top] = true
        }
        graph[top].forEach {
            if (!visited[it]) {
                stack.add(it)
            }
        }
    }
}

fun bfs(graph: Array<MutableList<Int>>, start: Int, bw: BufferedWriter, n: Int) {
    graph.forEach {
        it.sort()
    }
    val visited = Array(n + 1) { false }
    val queue = mutableListOf<Int>()
    queue.add(start)
    bw.write("$start ")
    visited[start] = true
    while (queue.isNotEmpty()) {
        val top = queue.removeFirst()
        graph[top].forEach {
            if (!visited[it]) {
                queue.add(it)
                bw.write("$it ")
                visited[it] = true
            }
        }
    }
}

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val (n, m, v) = br.readLine().toString().split(" ").map { it.toInt() }
    val graph = Array(n + 1) { mutableListOf<Int>() }
    repeat(m) {
        val (a, b) = br.readLine().toString().split(" ").map { it.toInt() }
        graph[a].add(b)
        graph[b].add(a)
    }
    dfs(graph, v, bw, n)
    bw.write("\n")
    bfs(graph, v, bw, n)
    br.close()
    bw.close()
}
