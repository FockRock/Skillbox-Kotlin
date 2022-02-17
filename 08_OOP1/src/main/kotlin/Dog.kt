import kotlin.random.Random

class Dog(
    energy: Int,
    weight: Int,
    maximumAge: Int,
    name: String
): Animal(
    energy,
    weight,
    maximumAge,
    name
) {
    override fun move() {
        super.move()
        println("Dog is running")
    }

    override fun birth(): Dog {
        val baby = Dog(
            name = name,
            maximumAge = maximumAge,
            energy = Random.nextInt(1,10),
            weight = Random.nextInt(1,5)
        )
        println("$name (dog) has born! Maximum age: $maximumAge, energy: ${baby.energy}, weight: ${baby.weight}")
        return baby
    }
}