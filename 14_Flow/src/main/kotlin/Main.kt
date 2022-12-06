import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlin.random.Random

fun main() {
    val p1 = Player("p1")
    val p2 = Player("p2")

    runBlocking {
        println("Игра начинается!")

        launch {
            Generator.flow
                .filter { !p1.playerNumbers.contains(it) }
                .collect {
                    p1.takeCard(it)
                    if (p1.playerNumbers.size == 15) cancel()
                }
        }
        launch {
            Generator.flow
                .filter { !p2.playerNumbers.contains(it) }
                .collect {
                    p2.takeCard(it)
                    if (p2.playerNumbers.size == 15) cancel()
                }
        }

        launch {
            delay(1000)
            println("Игроки взяли карточки, игра началась!")

            Generator.flow
                .filter { !Generator.gameNumbers.contains(it) }
                .collect {
                println("Следующее число - $it")
                    delay(100)
                Generator.gameNumbers.add(it)
                if (p1.playerNumbers.contains(it)) p1.playerNumbers.remove(it)
                if (p2.playerNumbers.contains(it)) p2.playerNumbers.remove(it)
                if (p1.playerNumbers.size == 0) {
                    println("Первый игрок победил, игра окончена!")
                    cancel()
                } else if (p2.playerNumbers.size == 0) {
                    println("Второй игрок победил, игра окончена!")
                    cancel()
                }
            }
        }
    }
}

class Player(private val name: String) {
    val playerNumbers = mutableListOf<Int>()
    private val firstLine = mutableListOf<Int>()
    private val secondLine = mutableListOf<Int>()
    private val thirdLine = mutableListOf<Int>()

    fun takeCard(i: Int) {
        playerNumbers.add(i)
        if (playerNumbers.size < 6) firstLine.add(i)
        else if (playerNumbers.size in 6..10) secondLine.add(i)
        else if (playerNumbers.size in 11..15) thirdLine.add(i)

        when (playerNumbers.size) {
            5 -> firstLine.sort()
            10 -> secondLine.sort()
            15 -> {
                thirdLine.sort()
                println("Карточка игрока $name: ")
                println("$firstLine")
                println("$secondLine")
                println("$thirdLine")
            }
        }
    }
}

object Generator {
    val flow = flow {
        while (currentCoroutineContext().isActive) {
            emit(Random.nextInt(1, 90))
        }
    }
    val gameNumbers = mutableListOf<Int>()
}