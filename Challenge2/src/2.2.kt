fun findMissingNumber(arr: IntArray): Int {
    val n = arr.size + 1
    val expectedSum = n * (n + 1) / 2
    val actualSum = arr.sum()
    return expectedSum - actualSum
}

fun main() {
    val numbers = intArrayOf(1, 5, 2, 6, 3)
    val missingNumber = findMissingNumber(numbers)
    println("The missing number is: $missingNumber")
}
