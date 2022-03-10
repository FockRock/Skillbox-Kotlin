sealed class FireType

object SingleShot : FireType()

data class Burst(
    val rounds: Int
) : FireType(){
}