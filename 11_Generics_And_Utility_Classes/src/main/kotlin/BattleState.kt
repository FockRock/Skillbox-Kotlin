sealed class BattleState {
    object Progress: BattleState()
    object VictoryFirst: BattleState()
    object VictorySecond: BattleState()
    object Draw: BattleState()
}