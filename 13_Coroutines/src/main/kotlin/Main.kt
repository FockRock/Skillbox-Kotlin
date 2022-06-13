import kotlinx.coroutines.*
import java.math.BigInteger
import kotlin.concurrent.thread
import kotlin.coroutines.coroutineContext
import kotlin.random.Random
import kotlin.system.measureTimeMillis

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

    runBlocking {
        val scope = CoroutineScope(this.coroutineContext)

        scope.launch {
            while (coroutineContext.isActive){
                delay(100)
                print(".")
            }
        }

        scope.launch {
            try {
                withTimeout(3000) {
                    yield()
                    val fibOne = Fibonacci.take(numberOne)
                    println("$numberOne number in Fibonacci sequence is $fibOne")
                }
            } catch (t: Throwable) {
                println("Calculation was too long!")
            }
        }

        scope.launch {
            try {
                withTimeout(3000) {
                    yield()
                    val fibTwo = Fibonacci.take(numberTwo)
                    println("$numberTwo number in Fibonacci sequence is $fibTwo")
                }
            } catch (t: Throwable) {
                println("Calculation was too long!")
            }
        }

        scope.launch {
            try {
                withTimeout(3000) {
                    yield()
                    val fibThree = Fibonacci.take(numberThree)
                    println("$numberThree number in Fibonacci sequence is $fibThree")
                }
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
        var f = 0.toBigInteger()
        if (currentCoroutineContext().isActive) {
            var f1 = 0.toBigInteger()
            var f2 = 1.toBigInteger()
            var i = 2

            println("Thread start: ${Thread.currentThread().name}")
            when (n) {
                0 -> f = 0.toBigInteger()
                1 -> f = 1.toBigInteger()
                2 -> f = 1.toBigInteger()
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
        return f
    }
}