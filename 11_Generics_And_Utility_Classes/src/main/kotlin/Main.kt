fun main() {
    val a = Stack<String>()

    a.push("One")
    a.push("Two")
    a.push("Three")
    a.push("Four")

    a.count()

    a.pop()
    a.pop()

    a.count()

    println("Stack is empty? ${a.isEmpty()}")

    a.pop()
    a.pop()

    println("Stack is empty? ${a.isEmpty()}")
}