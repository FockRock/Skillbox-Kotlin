import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlin.random.Random

val fullNumberList = mutableListOf<Int>()
var gameOver = false

fun main() {

    println("Доброе утро, день или вечер, начинаем игру в лото!")

    println("Сколько игроков сегодня играет?")
    val playerNumbers = readln().toInt()
    val playerList = mutableListOf<Player>()
    var i = 0

    while (playerNumbers != i) {
        val p = Player()
        playerList.add(p)
        p.playerName = "Игрок №${i + 1}"
        i++
    }

    println("Сколько у игроков будет карточек?")
    val cardNumbers = readln().toInt()
    if (cardNumbers > 4 || cardNumbers <= 0) {
        println("Количество карт должно быть в диапазоне от 1 до 3 штук!")
    } else {
        playerList.forEach {
            it.createCard(cardNumbers)
        }
    }


    runBlocking {
        launch {
            println("Начинаем игру!")
            Generator.flow.collect { it ->
                if (!fullNumberList.contains(it)) {
                    val a = it
                    println("Число $a!")
                    fullNumberList.add(a)
                    playerList.forEach { it ->
                        val p = it
                        if (!gameOver) {
                            p.cardList.forEach {
                                it.check(a)
                                if (it.cardNumbers.isEmpty()) {
                                    println("У ${p.playerName} ${it.cardName} пуста!")
                                    println("Игра окончена!")
                                    println("${p.playerName} побеждает!")
                                    cancel()
                                }
                            }
                        }
                    }
                }
            }
        }
    }

}

object Generator {
    val flow = flow {
        while (currentCoroutineContext().isActive) {
            val a = Random.nextInt(1, 91)
            if (!fullNumberList.contains(a)) {
                emit(a)
                delay(100)
            }
        }
    }
}

class Player {
    var playerName = ""
    val cardList = mutableListOf<Card>()

    fun createCard(n: Int) {
        var i = 0
        while (i != n) {
            val a = Card("Карточка №${i + 1}","$playerName")
            a.create()
            cardList.add(a)
            i++
        }
        println("У $playerName такие карты:")
        cardList.forEach {
            println(it.cardName)
            println(it.firstString)
            println(it.secondString)
            println(it.thirdString)
        }
    }
}

class Card(val cardName: String, val pName: String) {

    val cardNumbers = mutableListOf<Int>()
    val firstString = mutableListOf<Int>()
    val secondString = mutableListOf<Int>()
    val thirdString = mutableListOf<Int>()

    fun create(): List<List<Int>> {
        while (firstString.size != 5) {
            val i = Random.nextInt(1, 91)
            if (!cardNumbers.contains(i)) {
                firstString.add(i)
                cardNumbers.add(i)
            }
            firstString.sort()
        }
        while (secondString.size != 5) {
            val i = Random.nextInt(1, 91)
            if (!cardNumbers.contains(i)) {
                secondString.add(i)
                cardNumbers.add(i)
            }
            secondString.sort()
        }
        while (thirdString.size != 5) {
            val i = Random.nextInt(1, 91)
            if (!cardNumbers.contains(i)) {
                thirdString.add(i)
                cardNumbers.add(i)
            }
            thirdString.sort()
        }
        return mutableListOf(firstString, secondString, thirdString)
    }

    fun check(i: Int) {
        if (i in cardNumbers) {
            println("У $pName есть $i в $cardName!")
            remove(i)
        }
    }

    private fun remove(i: Int) {
        cardNumbers.remove(i)
        firstString.remove(i)
        secondString.remove(i)
        thirdString.remove(i)
        if (cardNumbers.isEmpty()) {
            gameOver = true
        } else {
            println("Оставшиеся числа в $cardName :")
            println("$firstString")
            println("$secondString")
            println("$thirdString")
        }
    }
}