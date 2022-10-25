import kotlinx.coroutines.*
import java.math.BigInteger

fun main(): Unit = runBlocking {
    val scope = CoroutineScope(Dispatchers.Default)
    val job = launch {
        try {
            withTimeout(3000) {
                println(Fibonacci.take(545554))
                println("Calculation complete!")
            }
        } catch (t: TimeoutCancellationException) {
            println("Calculation was too long!")
        }
    }
    println("Starting coroutine...")

    scope.launch {
        while (job.isActive){
            delay(200)
            print(".")
        }
    }
}

object Fibonacci {
    suspend fun take(n: Int): BigInteger? {

        var f = 0.toBigInteger()
        var n1 = 1.toBigInteger()
        var n2 = n1
        var i = 2

        if (n > 0) {
            when (n) {
                1, 2 -> f = n1
                else -> {
                    while (i != n) {
                        yield()
                        f = n1 + n2
                        if (n1 > n2) n2 = f
                        else n1 = f
                        i++
                    }
                }
            }
            return f
        } else println("Enter correct number!")
        return null
    }
}