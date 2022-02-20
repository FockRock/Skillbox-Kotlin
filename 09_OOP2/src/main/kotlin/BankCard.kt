abstract class BankCard (){
    var balance = 0

    open fun deposit(i: Int) {
        balance += i
        println("$i was deposited")
    }

    open fun pay(i: Int): Boolean {
        val result: Boolean = if (balance > i) {
            balance -= i
            println("$i was payed")
            true
        } else {
            println("Not enough money!")
            false
        }
        return result
    }

    open fun getBalance() {
        println("Your balance: $balance")
    }

    abstract fun getInfo()
}