import kotlinx.coroutines.*
import java.math.BigInteger
import kotlin.coroutines.CoroutineContext

fun main(): Unit = runBlocking {
    var n1 = 0.toBigInteger()
    var n2 = 0.toBigInteger()
    var n3 = 0.toBigInteger()

    val job1 = launch {
        println("Введите первое число:")
        var number = readLine()!!.toInt()
        number = check(number)
        withTimeout(10000) {
            try {
                n1 = Fibonacci.take(number)!!
            } catch (t: Throwable) {
            }
            cancel()
        }
    }

    val job2 = launch {
        println("Введите второе число:")
        var number = readLine()!!.toInt()
        number = check(number)
        withTimeout(10000) {
            try {
                n2 = Fibonacci.take(number)!!

            } catch (t: Throwable) {

            }
            cancel()
        }
    }

    val job3 = launch {
        println("Введите третье число:")
        var number = readLine()!!.toInt()
        number = check(number)
        withTimeout(10000) {
            try {
                n3 = Fibonacci.take(number)!!

            } catch (t: Throwable) {
            }
            cancel()
        }
    }

    launch {
        println("Начинается расчет чисел")
        while (job1.isActive || job2.isActive || job3.isActive) {
            print(".")
            delay(50)
        }
        println()
        if (n1 > 0.toBigInteger()) println("Первое число в последовательности Фибоначчи $n1")
        else println("Первое число не посчитано, ожидание было слишком долгим")
        if (n2 > 0.toBigInteger()) println("Второе число в последовательности Фибоначчи $n2")
        else println("Второе число не посчитано, ожидание было слишком долгим")
        if (n3 > 0.toBigInteger()) println("Третье число в последовательности Фибоначчи $n3")
        else println("Третье число не посчитано, ожидание было слишком долгим")
    }
}

object Fibonacci {
    suspend fun take(n: Int): BigInteger? {
        if (currentCoroutineContext().isActive) {
            var fib = 1.toBigInteger()
            var i = 2
            var a = 1.toBigInteger()
            var b = a

            if (n == 1 || n == 2) fib = 1.toBigInteger()
            else {
                while (i != n) {
                    delay(100)
                    fib = a + b
                    if (a > b) b = fib
                    else a = fib
                    i++
                }

            }
            return fib
        } else return null
    }
}

fun check(n: Int): Int {
    var num = n
    if (num > 0) {
    } else {
        while (num < 1) {
            println("Введите корректное число!")
            val a = readLine()!!.toInt()
            num = a
        }
    }
    return num
}