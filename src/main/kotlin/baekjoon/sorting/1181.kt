// 단어 정렬
package baekjoon.sorting

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().toInt()
    val wordList = mutableListOf<String>()
    repeat(n) {
        wordList.add(br.readLine().toString())
    }
    wordList.sortWith(compareBy({ it.length }, { it }))
    wordList.distinct().forEach {
        bw.write("$it\n")
    }
    br.close()
    bw.close()
}