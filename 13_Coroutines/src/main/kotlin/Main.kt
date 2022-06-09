import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.math.BigInteger

fun main(): Unit = runBlocking{

    println("Enter First number:")
    var numberOne = readLine()!!.toInt()
    numberOne = check(numberOne)

    println("Enter Second number:")
    var numberTwo = readLine()!!.toInt()
    numberTwo = check(numberTwo)

    println("Enter Third number:")
    var numberThree = readLine()!!.toInt()
    numberThree = check(numberThree)


    launch {
        val fibOne = Fibonacci.take(numberOne)
        println("$numberOne number in Fibonacci sequence is $fibOne")
    }

    launch {
        val fibTwo = Fibonacci.take(numberTwo)
        println("$numberTwo number in Fibonacci sequence is $fibTwo")
    }

    launch {
        val fibThree = Fibonacci.take(numberThree)
        println("$numberThree number in Fibonacci sequence is $fibThree")
    }
}

fun check(n: Int): Int {
    var number = n
    while (number < 0) {
        println("Enter another number!")
        number = readLine()!!.toInt()
    }
    println("Your number is $number")
    return number
}

object Fibonacci {

    suspend fun take(n: Int): BigInteger {
        var f1 = 0L
        var f2 = 1L
        var f = 1L
        var i = 3

        when (n) {
            0 -> f = 0
            1 -> f = 1
            2 -> f = 1
            else -> {
                while (i != n) {
                    if (f2 > f1) {
                        f1 = f
                    } else {
                        f2 = f
                    }
                    f = f1 + f2
                    i++
                }
            }
        }
        return f.toBigInteger()
    }
}