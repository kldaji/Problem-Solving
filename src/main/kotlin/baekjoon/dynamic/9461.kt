package baekjoon.dynamic

fun sequence(n: Int): Long {
    if (n == 1 || n == 2 || n == 3) return 1
    var a = 1L
    var b = 1L
    var c = 1L
    var tempA: Long
    var tempB: Long
    for (i in 4..n) {
        tempA = a
        tempB = b
        a = b
        b = c
        c = tempA + tempB
    }
    return c
}

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val t = br.readLine().toInt()
    repeat(t) {
        val n = br.readLine().toInt()
        bw.write("${sequence(n)}\n")
    }
    bw.close()
    br.close()
}