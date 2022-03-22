import kotlin.random.Random

class Battle(
    var firstTeam: Team,
    var secondTeam: Team
) {
    private var battleResult: BattleState = BattleState.Progress

    private fun battleStatus(): BattleState {
        if (firstTeam.currentWarriors() == 0) {
            println()
            println("Second team wins!")
            battleResult = BattleState.VictorySecond
        } else if (secondTeam.currentWarriors() == 0) {
            println()
            println("First Team wins!")
            battleResult = BattleState.VictoryFirst
        } else if (secondTeam.currentWarriors() == 0 && firstTeam.currentWarriors() == 0) {
            println()
            println("DRAW!")
            battleResult = BattleState.Draw
        } else {
            println("Continue...")
            println()
            println("FIRST TEAM: ${firstTeam.soldiers.size}, SECOND TEAM: ${secondTeam.soldiers.size}")
            println()
            battleResult = BattleState.Progress
        }
        return battleResult
    }


    fun battleIteration(iteration: Int) {
        var a = 0
        while (a != iteration) {
            if (battleResult == BattleState.Progress) {
                firstTeam.soldiers.shuffle()
                secondTeam.soldiers.shuffle()

                val firstTeamDeadList = mutableListOf<AbstractWarrior>()
                val secondTeamDeadList = mutableListOf<AbstractWarrior>()

                var i = 0
                while (i != firstTeam.currentWarriors() && i != secondTeam.currentWarriors()) {

                    val randomInt = Random.nextInt(0, 2)

                    if (randomInt == 0) {
                        println("Soldier from team 1 attacking first:")
                        firstTeam.soldiers[i].attack(secondTeam.soldiers[i])
                    } else {
                        println("Soldier from team 2 attacking first:")
                        secondTeam.soldiers[i].attack(firstTeam.soldiers[i])
                    }

                    if (randomInt == 0) {
                        if (!secondTeam.soldiers[i].isKilled) {
                            println("Soldier from team 2 attacking second:")
                            secondTeam.soldiers[i].attack(firstTeam.soldiers[i])
                        } else println("Soldier from team 2 is dead")
                    } else {
                        if (!firstTeam.soldiers[i].isKilled) {
                            println("Soldier from team 1 attacking second:")
                            firstTeam.soldiers[i].attack(secondTeam.soldiers[i])
                        } else println("Soldier from team 1 is dead")
                    }

                    if (secondTeam.soldiers[i].isKilled) {
                        secondTeamDeadList.add(secondTeam.soldiers[i])
                    }
                    if (firstTeam.soldiers[i].isKilled) {
                        firstTeamDeadList.add(firstTeam.soldiers[i])
                    }
                    i++
                }
                firstTeam.soldiers.removeAll(firstTeamDeadList)
                secondTeam.soldiers.removeAll(secondTeamDeadList)
                battleStatus()
            }
            a++
        }
    }
}