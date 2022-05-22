import java.util.*

class Solution {
    fun solution(numbers: IntArray, target: Int): Int {
        var answer = 0
        val queue: Queue<Pair<Int, Int>> = LinkedList()
        queue.add(Pair(numbers[0], 0))
        queue.add(Pair(-numbers[0],0))

        while(queue.isNotEmpty()) {
            val res = queue.remove()
            if (res.second == numbers.size-1) {
                if (res.first == target) {
                    answer++
                }
            } else {
                queue.addAll(bfs(numbers, res))
            }
        }

        return answer
    }
}

fun bfs(numbers: IntArray, i: Pair<Int, Int>): List<Pair<Int, Int>> {
    val index = i.second + 1
    val num = numbers[index]
    val result = mutableListOf<Pair<Int, Int>>()

    result.add(Pair(i.first + num, index))
    result.add(Pair(i.first - num, index))

    return result
}