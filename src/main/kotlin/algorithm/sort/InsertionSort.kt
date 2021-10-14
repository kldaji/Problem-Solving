package algorithm.sort

// in-place sorting
// 시간복잡도 : 1 + 2 + ... + (n-1) -> O(n^2)
// 정렬되어 있는 경우 O(n)
// 공간복잡도 : O(n)

fun insertionSort(unsorted: List<Int>): List<Int> {
    val insertionSortList = unsorted.toMutableList()
    for (i in 1 until insertionSortList.size) {
        val key = insertionSortList[i]
        var targetIndex = i - 1
        for (j in (i - 1) downTo 0) { // 앞쪽 원소 비교
            if (insertionSortList[j] > key) { // 더 큰 원소는 앞으로 이동
                insertionSortList[j + 1] = insertionSortList[j]
                targetIndex--
            } else { // 더 작은 원소 발견시 stop.
                break
            }
        }
        insertionSortList[targetIndex + 1] = key // 더 작은 원소 값 바로 앞에 저장.
    }
    return insertionSortList
}

fun main() {
    val testList = listOf(17, 123, 14, 34, 151, 4, 19)
    println(insertionSort(testList))
}