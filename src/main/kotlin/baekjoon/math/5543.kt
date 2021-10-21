package baekjoon.math

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val hamburgers = mutableListOf<Int>()
    val drinks = mutableListOf<Int>()
    repeat(3) {
        hamburgers.add(br.readLine().toInt())
    }
    repeat(2) {
        drinks.add(br.readLine().toInt())
    }
    bw.write("${hamburgers.minOf { it } + drinks.minOf { it } - 50}")
    br.close()
    bw.close()
}