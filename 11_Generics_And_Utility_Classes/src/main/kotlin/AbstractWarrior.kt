open class AbstractWarrior(
    maxHP: Int,
    private val weapon: AbstractWeapon,
    private val accuracy: Int,
    override val chanceToDodge: Int,
    override var isKilled: Boolean = false
): Warrior {
    var hp: Int = maxHP

    override fun attack(enemy: AbstractWarrior) {
        if (enemy.hp > 0) {
            try {
                val bullets = weapon.load()
                bullets.forEach {
                    if (accuracy > enemy.chanceToDodge) {
                        val damage: Int? = it?.takesDamage()
                        println("Bullets damage $damage")
                        enemy.hp = enemy.hp - damage!!
                        if (enemy.hp > 0) {
                            println("Enemy HP is now ${enemy.hp}")
                            println()
                        } else {
                            println("Enemy is dead!")
                            enemy.isKilled = true
                        }
                    }
                }
            } catch (e: NoAmmoException) {
                println("${NoAmmoException().message}")
                weapon.reload()
            }
        } else println("Enemy already dead!")
    }

    override fun takeDamage(damage: Int) {
        hp =- damage
    }
}