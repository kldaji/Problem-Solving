package baekjoon.dynamic

fun w(dp: Array<Array<Array<Int>>>, a: Int, b: Int, c: Int): Int {
    if (a <= 0 || b <= 0 || c <= 0) return 1
    if (a > 20 || b > 20 || c > 20) {
        if (dp[20][20][20] == 0) {
            dp[20][20][20] = w(dp, 20, 20, 20)
        }
        return dp[20][20][20]
    }
    if (b in (a + 1) until c) {
        if (dp[a][b][c] == 0) {
            dp[a][b][c] = w(dp, a, b, c - 1) + w(dp, a, b - 1, c - 1) - w(dp, a, b - 1, c)
        }
        return dp[a][b][c]
    }
    if (dp[a][b][c] == 0) {
        dp[a][b][c] = w(dp, a - 1, b, c) + w(dp, a - 1, b - 1, c) + w(dp, a - 1, b, c - 1) - w(dp, a - 1, b - 1, c - 1)
    }
    return dp[a][b][c]
}

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val dp = Array(21) { Array(21) { Array(21) { 0 } } }
    while (true) {
        val (a, b, c) = br.readLine().toString().split(" ").map { it.toInt() }
        if (a == -1 && b == -1 && c == -1) break
        bw.write("w($a, $b, $c) = ${w(dp, a, b, c)}\n")
    }
    bw.close()
    br.close()
}