import java.time.format.DateTimeFormatter
import java.time.LocalDateTime

class Solution {
    fun solution(fees: IntArray, records: Array<String>): IntArray {
        val lot = mutableMapOf<String, String>()
        val paid = mutableMapOf<String, Int>()

        val defaultTime = fees[0]
        val defaultFee = fees[1]
        val interval = fees[2]
        val intervalFee = fees[3]

        records.forEach { r ->
            val record = r.split(" ")

            lot.get(record[1]).let { inTime ->
                var duration = checkTime(inTime, record[0])

                paid.put(record[1], paid.getOrDefault(record[1], 0) + defaultFee)
                if (duration > defaultTime) {
                    duration -= defaultTime

                }

                lot.remove(record[1])
            } ?: {
                lot.put(record[1], record[0])
            }
        }

        var answer: IntArray = intArrayOf()
        return answer
    }

    fun checkTime(inTime: String?, outTime: String): Long {
        return 0
    }
}