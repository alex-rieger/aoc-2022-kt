fun main() {
    fun splitIntoCompartment(s: String): Pair<String, String> {
        val half = s.length / 2
        return Pair(s.substring(0, half), s.substring(half, s.length))
    }

    fun toIterableChars(i: String): Iterable<Char> {
        return i.toCharArray().asIterable()
    }

    fun toPriority(i: Char): Int {
        if (i.isUpperCase()) {
            return i.code.minus(38)
        }
        return i.code.minus(96)
    }

    fun part1(input: List<String>): Int {
        return input.map { splitIntoCompartment(it) }.map { compartments ->
                    val (first, second) = compartments
                    toIterableChars(first).intersect(toIterableChars(second))
                }.flatten().map { toPriority(it) }.reduce { acc, priority -> acc + priority }
    }

    fun part2(input: List<String>): Int {
        return input.chunked(3).map { chunk ->
            val (first, second, third) = chunk
            toIterableChars(first).intersect(toIterableChars(second)).intersect(toIterableChars(third))
        }.flatten().map { toPriority(it) }.reduce { acc, priority -> acc + priority }
    }

    val input = readInput("Day03")
    println(part1(input))
    println(part2(input))
}
