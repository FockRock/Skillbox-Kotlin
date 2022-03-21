import kotlin.random.Random

class Team(
    numberOfSoldiers: Int
) {
    var soldiers: MutableList<AbstractWarrior> = mutableListOf()

    init {
        var i = 0
        while (i != numberOfSoldiers) {
            when (Random.nextInt(100)) {
                in 0..10 -> {
                    soldiers.add(General())
                    println("General added to the Team")
                }
                in 11..40 -> {
                    soldiers.add(Captain())
                    println("Captain added to the Team")
                }
                else -> {
                    soldiers.add(Soldier())
                    println("Soldier added to the Team")
                }
            }
            i++
        }
        println(soldiers)
    }

    fun currentHealth(): Int {
        var health = 0
        soldiers.forEach {
            health += it.hp
        }
        return health
    }

    fun currentWarriors() = soldiers.size
}