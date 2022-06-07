class Solution {
    fun solution(fees: IntArray, records: Array<String>): IntArray {
        val lot = mutableMapOf<String, String>()
        val totalTime = mutableMapOf<String, Int>()
        val paid = mutableMapOf<String, Int>()

        val defaultTime = fees[0]
        val defaultFee = fees[1]
        val interval = fees[2]
        val intervalFee = fees[3]

        records.forEach { r ->
            val record = r.split(" ")
            lot.get(record[1])?.let { inTime ->
                totalTime.put(record[1], totalTime.getOrDefault(record[1], 0) + checkTime(inTime, record[0]))
                lot.remove(record[1])
            } ?: run {
                lot.put(record[1], record[0])
            }
        }

        lot.forEach { l ->
            totalTime.put(l.key, totalTime.getOrDefault(l.key, 0) + checkTime(l.value, "23:59"))
        }

        totalTime.forEach { t ->
            paid.put(t.key, paid.getOrDefault(t.key, 0) + defaultFee)
            var duration = t.value - defaultTime
            while(duration > 0) {
                paid.put(t.key, paid.getOrDefault(t.key, 0) + intervalFee)
                duration -= interval
            }
        }

        return paid.toSortedMap().values.toIntArray()
    }

    fun checkTime(incoming: String, outgoing: String): Int {
        val inTime = incoming.split(":")
        val outTime = outgoing.split(":")

        return 60 * (outTime[0].toInt() - inTime[0].toInt()) + (outTime[1].toInt() - inTime[1].toInt())
    }
}