class AbstractWeapon(
    val maxRounds: Int,
    val fireType: FireType,
    val ammo: Ammo,
    val clip: Stack<Ammo>
) {
    private fun makeBullet(): Ammo {
        return when (ammo) {
            Ammo.GRENADE -> Ammo.GRENADE
            Ammo.PISTOL_BULLET -> Ammo.PISTOL_BULLET
            Ammo.SHOTGUN_SHELL -> Ammo.SHOTGUN_SHELL
            Ammo.RIFLE_BULLET -> Ammo.RIFLE_BULLET
        }
    }

    fun reload(): Stack<Ammo> {
        var i = 0
        clip.isEmpty()
        while (i != maxRounds) {
            clip.push(makeBullet())
            i++
        }
        return clip
    }

    fun load(): List<Ammo?> {
        val bulletsForFire = mutableListOf<Ammo?>()
        bulletsForFire.add(clip.pop())

        return bulletsForFire.toList()
    }
}