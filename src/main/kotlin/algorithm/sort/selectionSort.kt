package algorithm.sort

// in-place sorting
// 시간복잡도 : (n-1) * (n-2) * ... * 1 -> O(n^2)
// 공간복잡도 : O(n)

fun selectionSort(unsortedList: List<Int>): List<Int> {
    val selectionSortList = unsortedList.toMutableList()
    for (i in 0 until selectionSortList.size - 1) { // minValue 넣을 위치 설정.
        var minIndex = i
        for (j in i + 1 until selectionSortList.size) { // (i+1)번째 부터 마지막까지 최솟값 찾기.
            if (selectionSortList[minIndex] > selectionSortList[j]) {
                minIndex = j
            }
        }
        // swap
        val temp = selectionSortList[i]
        selectionSortList[i] = selectionSortList[minIndex]
        selectionSortList[minIndex] = temp
    }
    return selectionSortList
}

fun main() {
    val testList = listOf(17, 123, 14, 34, 151, 4, 19)
    println(selectionSort(testList))
}