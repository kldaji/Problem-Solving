package algorithm.sort

// in-place sorting
// 시간복잡도 : (n-1) * (n-2) * ... * 1 -> O(n^2)
// 공간복잡도 : O(n)

fun bubbleSort(unsortedList: List<Int>): List<Int> {
    val bubbleSortList = unsortedList.toMutableList()
    for (i in 0 until bubbleSortList.size) { // 리스트 사이즈만큼 반복.
        for (j in 1 until bubbleSortList.size - i) { // 맨 뒤 i개는 정렬 되었음.
            if (bubbleSortList[j - 1] > bubbleSortList[j]) { // swap
                val temp = bubbleSortList[j - 1]
                bubbleSortList[j - 1] = bubbleSortList[j]
                bubbleSortList[j] = temp
            }
        }
    }
    return bubbleSortList
}

fun main() {
    val testList = listOf(17, 123, 14, 34, 151, 4, 19)
    println(bubbleSort(testList))
}