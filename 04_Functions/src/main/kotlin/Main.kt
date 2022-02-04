fun main() {

    val initialString = """F2p)v"y233{0->c}ttelciFc"""

    val firstHalfString = initialString.take(initialString.length / 2)
    val secondHalfString = initialString.takeLast(initialString.length / 2)

    println(firstHalf(firstHalfString) + secondHalf(secondHalfString))
}

fun firstHalf(string: String): String {
    val shiftedString = func(string, 1)
    val firstReplace = shiftedString.replace("5","s")
    val secondReplace = firstReplace.replace("4", "u")
    val secondShiftedString = func(secondReplace, -3)
    return secondShiftedString.replace("0", "o")
}

fun secondHalf(string: String): String {
    val reversedString = string.reversed()
    val shiftedString = func(reversedString, -4)
    return shiftedString.replace("_", " ")
}

fun func(s: String, i: Int): String {
    return s.map { char -> char + i }.joinToString("")
}