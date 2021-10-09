package baekjoon.dynamic

fun fibonacci(array: Array<Int>, n: Int): Int{
    if (n <= 1) return array[n]
    return if (array[n] == 0) {
        array[n] = fibonacci(array, n - 1) + fibonacci(array, n - 2)
        array[n]
    } else {
        array[n]
    }
}

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val t = br.readLine().toInt()
    val zeroArray = Array(41) { 0 }
    zeroArray[0] = 1
    zeroArray[1] = 0
    val oneArray = Array(41) { 0 }
    oneArray[0] = 0
    oneArray[1] = 1
    fibonacci(zeroArray, 40)
    fibonacci(oneArray, 40)
    repeat(t) {
        val n = br.readLine().toInt()
        bw.write("${zeroArray[n]} ${oneArray[n]}\n")
    }
    bw.close()
    br.close()
}