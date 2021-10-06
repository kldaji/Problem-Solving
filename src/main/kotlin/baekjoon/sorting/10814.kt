// 나이순 정렬
package baekjoon.sorting

data class Member(val id: Int, val age: String, val name: String) {
    override fun toString(): String {
        return "$age $name"
    }
}

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().toInt()
    val memberList = mutableListOf<Member>()
    for (i in 1..n) {
        val (age, name) = br.readLine().toString().split(" ")
        memberList.add(Member(i, age, name))
    }
    memberList.sortWith(compareBy({ it.age.toInt() }, { it.id }))
    for (member in memberList) {
        bw.write("$member\n")
    }
    br.close()
    bw.close()
}