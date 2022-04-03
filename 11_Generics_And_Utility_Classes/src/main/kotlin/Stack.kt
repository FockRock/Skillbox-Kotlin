import kotlin.random.Random

class Stack<T> {
    private val mL: MutableList<T> = mutableListOf()

    fun push(item: T) {
        println("Element $item added to clip")
        mL.add(item)
    }

    fun pop(): T? =
        if (mL.isNotEmpty()) {
            println("Element ${mL[mL.size-1]} ready for fire")
            mL.removeAt(mL.size-1)
        } else null

    fun isEmpty(): Boolean {
        return mL.isEmpty()
    }

    fun count(): Int {
        var a = 0
        while (a != mL.size) {
            a++
        }
        println("Clip has $a bullets")
        return a
    }
}

fun Int.chance(): Boolean {
    val a = Random.nextInt(100)
    return this <= a
}

class NoAmmoException: Throwable("You have no ammo")