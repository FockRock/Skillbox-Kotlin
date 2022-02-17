import kotlin.random.Random

open class Animal(
    var energy: Int,
    var weight: Int,
    var maximumAge: Int,
    var name: String
) {
    private var age: Int = Random.nextInt(7)
    val isTooOld = maximumAge <= age

    fun sleep() {
        if (!isTooOld) {
            energy += 5
            age++
            println("$name is sleeping")
        }
    }

    fun eat() {
        if (!isTooOld) {
            energy += 3
            weight++
            tryIncrementAge()
            println("$name is eating")
        }
    }

    open fun move() {
        if (energy > 5 && weight > 1 && !isTooOld) {
            energy -= 5
            weight--
            tryIncrementAge()
            println("$name is moving")
        }
    }

    open fun birth(): Animal {
        val baby = Animal(
            name = this.name,
            maximumAge = this.maximumAge,
            energy = Random.nextInt(1,10),
            weight = Random.nextInt(1,5)
        )
        println("$name has born! Maximum age: $maximumAge, energy: ${baby.energy}, weight: ${baby.weight}")
        return baby
    }

    private fun tryIncrementAge() {
        if (Random.nextBoolean()) {
            age++
        }
    }
}