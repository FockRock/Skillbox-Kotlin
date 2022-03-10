enum class Ammo(
    private val damage: Int,
    private val criticalChance: Int,
    private val criticalDamage: Int
) {
    PISTOL_BULLET(10, 5, 3),
    SHOTGUN_SHELL(30, 10, 6),
    RIFLE_BULLET(20, 8, 4),
    GRENADE(50, 20, 10);

    fun takeDamage(): Int {
        val a = criticalChance.chance()
        return if (a) damage else damage * criticalDamage
    }

}