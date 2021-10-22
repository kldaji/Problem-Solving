package baekjoon.dynamic

fun drinkMaxGrape(n: Int, grapes: List<Long>): Long {
    val dp = LongArray(n) { 0 }
    dp[0] = grapes[0]
    if (n == 1) return dp[0]
    dp[1] = grapes[0] + grapes[1]
    if (n == 2) return dp[1]
    dp[2] = maxOf(grapes[0] + grapes[2], grapes[1] + grapes[2], dp[1])
    if (n == 3) return dp[2]
    for (i in 3 until n) {
        dp[i] = maxOf(dp[i - 1], dp[i - 3] + grapes[i - 1] + grapes[i], dp[i - 2] + grapes[i])
    }
    return dp.maxOf { it }
}

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().toInt()
    val grapes = mutableListOf<Long>()
    repeat(n) {
        grapes.add(br.readLine().toLong())
    }
    bw.write("${drinkMaxGrape(n, grapes)}")
    bw.close()
    br.close()
}