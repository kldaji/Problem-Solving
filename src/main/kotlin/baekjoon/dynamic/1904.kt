package baekjoon.dynamic

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().toInt()
    var a = 1
    var b = 1
    var temp: Int
    for (i in 2..n) {
        temp = a
        a = b
        b = (b + temp) % 15746
    }
    bw.write("$b\n")
    bw.close()
    br.close()
}