import org.w3c.dom.ranges.Range

fun main() {
    fun toIntRange(inputs: String): IntRange {
        val (start, end) = inputs.split('-')
        return start.toInt()..end.toInt()
    }

    fun isFullyContained(left: IntRange, right: IntRange): Boolean {
        return (left.min() >= right.min() && left.max() <= right.max()) || (right.min() >= left.min() && right.max() <= left.max())
    }

    fun isOverlapping(left: IntRange, right: IntRange): Boolean {
        return left.min() in right ||
                left.max() in right ||
                right.min() in left ||
                right.max() in left
    }

    fun part1(input: List<String>): Int {
        var result = 0
        input.map { line ->
            val (left, right) = line.split(',').map { toIntRange(it) }
            if (isFullyContained(left, right)) {
                result = result.plus(1)
            }
        }
        return result
    }

    fun part2(input: List<String>): Int {
        var result = 0
        input.map { line ->
            val (left, right) = line.split(',').map { toIntRange(it) }
            if (isOverlapping(left, right)) {
                result = result.plus(1)
            }
        }
        return result
    }

    val input = readInput("Day04")
    println(part1(input))
    println(part2(input))
}
