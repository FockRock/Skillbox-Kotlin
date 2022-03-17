interface Warrior {
    val isKilled: Boolean
    val chanceToDodge: Int

    fun attack(enemy: AbstractWarrior)
    fun takeDamage(damage: Int)
}