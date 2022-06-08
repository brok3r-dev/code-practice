class Solution {
    fun solution(price: Int, money: Int, count: Int): Long {
        var answer: Long = money.toLong()

        for (i in 1 .. count) {
            answer -= price.toLong() * i.toLong()
        }

        return Math.abs(Math.min(answer, 0))
    }
}