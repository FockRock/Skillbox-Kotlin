import kotlinx.coroutines.*
import java.math.BigInteger

fun main(): Unit = runBlocking {

    val scope = CoroutineScope(this.coroutineContext)

    lateinit var a: BigInteger
    lateinit var b: BigInteger


    val job1 = scope.launch {
        try {
            a = Fibonacci.take(getNumber())
//            println("Первое число в последовательности Фибоначчи - ${Fibonacci.take(getNumber())}")
        } catch (t: Throwable) {}
    }

    val job2 = scope.launch {
        try {
            b = Fibonacci.take(getNumber())
//            println("Второе число в последовательности Фибоначчи - ${Fibonacci.take(getNumber())}")
        } catch (t: Throwable) {}
    }

    scope.launch {
        while (job1.isActive || job2.isActive) {
            print(".")
            delay(50)
        }
        println()
        job1.join()
        try{
            println("Первое число в последовательности Фибоначчи - $a")
        } catch (t: Throwable) {
            println("Первое число слишком большое!")
        }
        job2.join()
        try {
            println("Второе число в последовательности Фибоначчи - $b")
        } catch (t: Throwable) {
            println("Второе число слишком большое!")
        }

    }
}

object Fibonacci {
    suspend fun take(n: Int): BigInteger {

        var i = 1
        var f1 = 0.toBigInteger()
        var f2 = 1.toBigInteger()
        var f3 = 0.toBigInteger()

//        while (currentCoroutineContext().isActive) {
        withTimeout(10000) {
            when (n) {
                0 -> f3 = f1
                1, 2 -> f3 = f1 + f2
                else -> {
                    while (i != n) {
                        f3 = f1 + f2
                        if (f1 < f2) f1 = f3
                        else f2 = f3
                        delay(10)
                        i++
                    }
                }
            }
        }
//        }
        return f3
    }
}

fun getNumber(): Int {
    println("Пожалуйста, введите число:")
    var a: Int = readLine()!!.toInt()
    while (a < 0) {
        println("Введите корректное число!")
        a = readln().toInt()
    }
    return a
}