fun getCaloriesPerElveList(input: List<String>): List<Int> {
    var buffer = 0
    return input.fold(mutableListOf<Int>()) { acc, calories ->
        if (calories.isEmpty()) {
            acc.add(buffer)
            buffer = 0
        } else {
            buffer = buffer.plus(calories.toInt())
        }
        acc
    }
}

fun main() {
    fun part1(input: List<String>): Int {
        return getCaloriesPerElveList(input).max()
    }

    fun part2(input: List<String>): Int {
        return getCaloriesPerElveList(input).sorted().takeLast(3).sum()
    }

//    // test if implementation meets criteria from the description, like:
//    val testInput = readInput("Day01_test")
//    check(part1(testInput) == 1)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
