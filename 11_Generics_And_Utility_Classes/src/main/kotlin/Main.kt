fun main() {

    val a = AbstractWeapon(12, Burst(5), Ammo.RIFLE_BULLET, Stack())
    a.reload()
    a.load()
}