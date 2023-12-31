class AbstractWeapon(
    private val maxRounds: Int,
    private val fireType: FireType,
    private val ammo: Ammo,
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
        println("Weapon reloaded")
        println()
        return clip
    }

    fun load(): MutableList<Ammo?> {
        val bulletsForFire = mutableListOf<Ammo?>()
        val bulletsInClip = clip.count()

        if (fireType == SingleShot && bulletsInClip >= 1) {
            bulletsForFire.add(clip.pop())
        } else if (fireType == Burst() && bulletsInClip >= 3) {
            var i = 0
            while (i != Burst().rounds) {
                bulletsForFire.add(clip.pop())
                i++
            }
        } else throw NoAmmoException()
        return bulletsForFire
    }
}