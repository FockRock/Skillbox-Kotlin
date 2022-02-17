import kotlin.random.Random

class Bird(
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
        println("Bird is flying")
    }

    override fun birth(): Bird {
        val baby = Bird(
            name = name,
            maximumAge = maximumAge,
            energy = Random.nextInt(1,10),
            weight = Random.nextInt(1,5)
        )
        println("$name (bird) has born! Maximum age: $maximumAge, energy: ${baby.energy}, weight: ${baby.weight}")
        return baby
    }
}