class General: AbstractWarrior(
    300,
    Weapons.createGrenadeLauncher(),
    40,
    10
)

class Captain: AbstractWarrior(
    200,
    Weapons.createRifle(),
    30,
    10
)

class Soldier: AbstractWarrior(
    150,
    Weapons.createShotgun(),
    20,
    10
)
