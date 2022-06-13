class Solution {
    fun solution(info: Array<String>, query: Array<String>): IntArray {
        val answer = IntArray(query.size) { 0 }
        val root = Trie("root")

        for (i in info) {
            val list = i.split(" ")
            root.insert(list)
        }

        for (q in query.indices) {
            val list = query[q].replace(" and", "").split(" ")
            val count = root.search(list)
            answer[q] = count
        }

        return answer
    }
}

data class Trie(
    val name: String,
    var count: Int = 1,
    val children: MutableList<Trie> = mutableListOf()
) {
    fun insert(list: List<String>) {
        if (list.isEmpty()) { return }

        val index = this.children.find(list[0])
        if (index == -1) {
            this.children.add(Trie(list[0]))
            this.children[this.children.find(list[0])].insert(list.subList(1, list.size))
        } else {
            this.children[index].count += 1
            this.children[index].insert(list.subList(1, list.size))
        }
    }

    fun search(list: List<String>): Int {
        return when (list.size) {
            1 -> this.children.filter { it.name.toInt() >= list[0].toInt() }.sumBy { it.count }
            else -> {
                if (list[0] == "-") {
                    var count = 0
                    for (t in this.children) {
                        count += t.search(list.subList(1, list.size))
                    }
                    count
                } else {
                    val index = this.children.find(list[0])
                    if (index != -1) {
                        this.children[index].search(list.subList(1, list.size))
                    } else {
                        0
                    }
                }
            }
        }
    }
}

fun MutableList<Trie>.find(s: String): Int {
    for (i in this.indices) {
        if (this[i].name == s) {
            return i
        }
    }
    return -1
}