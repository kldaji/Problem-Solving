package baekjoon.dfs_bfs


fun dfs(land: Array<Array<Int>>, x: Int, y: Int, m: Int, n: Int) {
    val dx = listOf(1, -1, 0, 0)
    val dy = listOf(0, 0, 1, -1)
    for (i in 0..3) {
        val nx = x + dx[i]
        val ny = y + dy[i]
        if (nx in 0 until m && ny in 0 until n && land[ny][nx] == 1) {
            land[ny][nx] = 0
            dfs(land, nx, ny, m, n)
        }
    }
}

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val t = br.readLine().toInt()
    repeat(t) {
        val (m, n, k) = br.readLine().split(" ").map { it.toInt() }
        val land = Array(n) { Array(m) { 0 } }
        var earthworm = 0
        repeat(k) {
            // x : 가로, y: 세로
            val (x, y) = br.readLine().split(" ").map { it.toInt() }
            land[y][x] = 1
        }
        for (i in 0 until n) {
            for (j in 0 until m) {
                if (land[i][j] == 1) {
                    earthworm++
                    land[i][j] = 0
                    dfs(land, j, i, m, n)
                }
            }
        }
        bw.write("$earthworm\n")
    }
    br.close()
    bw.close()
}
