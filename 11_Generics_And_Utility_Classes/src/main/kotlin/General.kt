class General: AbstractWarrior(
    300,
    Weapons.createGrenadeLauncher(),
    50,
    50
)

class Captain: AbstractWarrior(
    200,
    Weapons.createRifle(),
    40,
    40
)

class Soldier: AbstractWarrior(
    200,
    Weapons.createShotgun(),
    30,
    30
)
