fun main() {

    println("Enter number more then 0:")
    var n = readLine()?.toIntOrNull() ?: return

    while (n <= 0) {
        println("Enter correct number!")
        n = readLine()?.toIntOrNull() ?: return
    }

    val fullList: MutableList<String> = phoneCheck(n)
    val phoneList = fullList.filter { it.contains("+7") }
    println("All phone numbers, that you entered: $phoneList")

    val uniquePhoneList = phoneList.toSet().toMutableList()
    val uniquePhoneListSize = uniquePhoneList.size
    println("You have $uniquePhoneListSize unique phone numbers: $uniquePhoneList")

    val uniqueListLength = uniquePhoneList.sumBy { it.length }
    println("Length of all unique elements $uniqueListLength")

    println("Enter $uniquePhoneListSize names to your numbers!")
    val phoneBook: MutableMap<String, String> = mutableMapOf()
    var index = 0
    while (index != uniquePhoneListSize) {
        println("Enter name for number ${uniquePhoneList[index]}")
        val name = readLine().toString()
        phoneBook[uniquePhoneList[index]] = name
        index++
    }

    println()
    println("Great!")
    println("Your phonebook:")
    phoneBook.forEach {println("${it.value} - ${it.key}") }
}

fun phoneCheck(n: Int): MutableList<String> {
    println("You need $n phone numbers!")
    var i = 1
    val phoneList: MutableList<String> = mutableListOf()
    while (i != n + 1) {
        println("Enter $i phone number:")
        val phone = readLine().toString()
        phoneList.add(phone)
        i++
    }
    return phoneList
}