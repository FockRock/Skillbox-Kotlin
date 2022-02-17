import kotlin.random.Random

class NatureReserve {
    private var animalList: MutableList<Animal> = mutableListOf(
        Bird(Random.nextInt(50), Random.nextInt(10), Random.nextInt(8), "Bird1"),
        Bird(Random.nextInt(50), Random.nextInt(10), Random.nextInt(8), "Bird2"),
        Bird(Random.nextInt(50), Random.nextInt(10), Random.nextInt(8), "Bird3"),
        Bird(Random.nextInt(50), Random.nextInt(10), Random.nextInt(8), "Bird4"),
        Bird(Random.nextInt(50), Random.nextInt(10), Random.nextInt(8), "Bird5"),
        Fish(Random.nextInt(20), Random.nextInt(7), Random.nextInt(3), "Fish1"),
        Fish(Random.nextInt(20), Random.nextInt(7), Random.nextInt(3), "Fish2"),
        Fish(Random.nextInt(20), Random.nextInt(7), Random.nextInt(3), "Fish3"),
        Dog(Random.nextInt(60), Random.nextInt(15), Random.nextInt(20), "Dog1"),
        Dog(Random.nextInt(60), Random.nextInt(15), Random.nextInt(20), "Dog2"),
        Animal(Random.nextInt(40), Random.nextInt(8), Random.nextInt(10), "Animal1"),
        Animal(Random.nextInt(40), Random.nextInt(8), Random.nextInt(10), "Animal2"),
        Animal(Random.nextInt(40), Random.nextInt(8), Random.nextInt(10), "Animal3")
    )

    init {
        println("Enter number:")
        val n = readLine()?.toIntOrNull()
        var i = 0


        while (n != i) {
            if (animalList.size > 1){

                val deadList = mutableListOf<Animal>()
                val birthList = mutableListOf<Animal>()

                animalList.forEach {
                    when (Random.nextInt(1, 5)) {
                        1 -> it.sleep()
                        2 -> it.eat()
                        3 -> it.move()
                        4 -> {
                            println("${it.name} born the baby!")
                            val baby = it.birth()
                            birthList.add(baby)
                        }
                    }
                    if (it.isTooOld) deadList.add(it)
                }
                animalList.removeAll(deadList)
                println("Dead animals: $deadList")
                println("New animals: $birthList")
                animalList.addAll(birthList)
                println("We have ${animalList.size} animals!")
                i++
            } else println("All animals are dead!")
        }
    }
}