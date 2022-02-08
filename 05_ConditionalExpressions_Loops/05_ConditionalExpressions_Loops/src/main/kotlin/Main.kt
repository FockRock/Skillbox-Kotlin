fun main() {

    println("Введите число для расчета:")
    var n = readLine()?.toIntOrNull() ?: return

    when (n) {
        0 -> {
            while ( n == 0){
                println("Введите корректное число!")
                n = readLine()?.toIntOrNull() ?: return
            }
            print("$n число из ряда Фибоначчи: ")
            println(fibonacci(n))
        }
        else -> {
            print("$n число из ряда Фибоначчи: ")
            println(fibonacci(n))
        }
    }
}

fun fibonacci(n: Int): Long {
    var i = 0
    var fFirst = 0L
    var fSecond = 1L
    var f = 0L
    when (n) {
        1 -> {
            f = 0
        }
        2 -> {
            f = 1
        }
        else -> {
            while (i != n - 2) {
                f = fFirst + fSecond
                if (fFirst >= fSecond) fSecond = f
                else fFirst = f
                i++
            }
        }
    }
    return f
}