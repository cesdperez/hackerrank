fun main(args: Array<String>) {
    val numbers = readInput()
    numbers.reversed().forEach { print("$it ") }
}

private fun readInput(): List<Int> {
    val n = readLine()!!.trim().toInt()

    return readLine()!!
            .split(' ')
            .take(n)
            .map { it.trim().toInt() }
}
