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

    fun count() {
        var a = 0
        while (a != mL.size) {
            println(mL[a])
            a++
        }
    }
}

fun Int.chance(): Boolean {
    val a = Random.nextInt(100)
    return this <= a
}