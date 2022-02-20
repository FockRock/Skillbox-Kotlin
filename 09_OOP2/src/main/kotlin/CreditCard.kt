abstract class CreditCard: BankCard() {
    var creditLimit = 10000
    var creditMoney = 8000

    override fun getInfo() {
        println("Credit money: $creditMoney")
        println("Your money: $balance")
    }

    override fun deposit(i: Int) {
        val difference = creditLimit - creditMoney
        if (difference > 0) {
            val a = i - difference
            val b = i - a
            creditMoney +=b
            balance += a
        } else if (difference == 0) balance +=i
        getInfo()
    }

    override fun pay(i: Int): Boolean {
        var result = true
        var price = i

        if (balance > i) {
            balance -= i
        } else if (balance == 0) {
            creditMoney -= i
        } else if (i < balance + creditMoney) {
            price -= balance
            balance = 0
            creditMoney -= price
        } else {
            println("Not enough money!")
            result = false
        }
        getInfo()
        return result
    }
}