import kotlinx.coroutines.*
import java.math.BigInteger
import kotlin.concurrent.thread
import kotlin.coroutines.coroutineContext
import kotlin.random.Random
import kotlin.system.measureTimeMillis

//val scope = CoroutineScope(Dispatchers.Default)

fun main() {
    println("Enter First number:")
    var numberOne = readLine()!!.toInt()
    numberOne = check(numberOne)

    println("Enter Second number:")
    var numberTwo = readLine()!!.toInt()
    numberTwo = check(numberTwo)

    println("Enter Third number:")
    var numberThree = readLine()!!.toInt()
    numberThree = check(numberThree)

//    scope.coroutineContext.job.join()
    runBlocking {
        val scope = CoroutineScope(this.coroutineContext)

        scope.launch {
            try {
                val fibOne = Fibonacci.take(numberOne)
                println("$numberOne number in Fibonacci sequence is $fibOne")
            } catch (t: Throwable) {
                println("Calculation was too long!")
            }
        }

        scope.launch {
            try {
                val fibTwo = Fibonacci.take(numberTwo)
                println("$numberTwo number in Fibonacci sequence is $fibTwo")
            } catch (t: Throwable) {
                println("Calculation was too long!")
            }
        }

        scope.launch {
            try {
                val fibThree = Fibonacci.take(numberThree)
                println("$numberThree number in Fibonacci sequence is $fibThree")
            } catch (t: Throwable) {
                println("Calculation was too long!")
            }
        }
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
        var f = 0L
        if (currentCoroutineContext().isActive) {
            withTimeout(3000) {

                var f1 = 0L
                var f2 = 1L
                var i = 2
                delay(Random.nextInt(3000).toLong())

                println("Thread start: ${Thread.currentThread().name}")
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
            }
        }
        return f.toBigInteger()
    }
}