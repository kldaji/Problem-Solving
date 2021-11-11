package baekjoon.dfs_bfs

import java.util.*

fun traverse(queue: Queue<Pair<Int, Int>>, visited: Array<Boolean>, nDest: Int, count: Int) {
    if (nDest in 0 until 100001 && !visited[nDest]) {
        queue.add(Pair(nDest, count + 1))
        visited[nDest] = true
    }
}

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val (n, k) = br.readLine().split(" ").map { it.toInt() }
    val queue: Queue<Pair<Int, Int>> = LinkedList()
    val visited = Array(100001) { false }
    queue.add(Pair(n, 0))
    visited[n] = false
    var result = 0
    while (queue.isNotEmpty()) {
        val (dest, count) = queue.poll()
        if (dest == k) {
            result = count
            break
        }
        traverse(queue, visited, dest + 1, count)
        traverse(queue, visited, dest - 1, count)
        traverse(queue, visited, dest * 2, count)
    }
    bw.write("$result")
    br.close()
    bw.close()
}
