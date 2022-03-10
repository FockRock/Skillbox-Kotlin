object Weapons {
    fun createPistol(): AbstractWeapon {
        return AbstractWeapon(8,SingleShot,Ammo.PISTOL_BULLET,Stack())
    }

    fun createShotgun(): AbstractWeapon {
        return AbstractWeapon(10,SingleShot,Ammo.SHOTGUN_SHELL,Stack())
    }

    fun createRifle(): AbstractWeapon {
        return AbstractWeapon(15,Burst(3),Ammo.RIFLE_BULLET,Stack())
    }

    fun createGrenadeLauncher(): AbstractWeapon {
        return AbstractWeapon(3,SingleShot,Ammo.GRENADE,Stack())
    }
}