package baekjoon.back_tracking

data class Group(val id: String, val selected: Boolean)

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val group1 = Group("1", false)
    val group2 = Group("1", false)
    val groupList = listOf(group1, group2)

    println("${group1 == group2}")
    br.close()
    bw.close()
}