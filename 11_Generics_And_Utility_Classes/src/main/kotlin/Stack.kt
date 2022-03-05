class Stack<T> {
    private val mL: MutableList<T> = mutableListOf()

    fun push(item: T) {
        println("Element $item added")
        mL.add(item)
    }

    fun pop(): T? =
        if (mL.isNotEmpty()) {
            println("Element ${mL[mL.size-1]} deleted")
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