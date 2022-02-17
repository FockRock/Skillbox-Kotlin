import kotlin.random.Random

class Fish(
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
        println("Fish is swimming")
    }

    override fun birth(): Fish {
        val baby = Fish(
            name = name,
            maximumAge = maximumAge,
            energy = Random.nextInt(1,10),
            weight = Random.nextInt(1,5)
        )
        println("$name (fish) has born! Maximum age: $maximumAge, energy: ${baby.energy}, weight: ${baby.weight}")
        return baby
    }
}