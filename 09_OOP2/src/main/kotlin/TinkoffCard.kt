class TinkoffCard : CreditCard() {

    init {
        println("Tinkoff card was created!")
    }

    var totalDeposit = 0
    var depositBonus = 0
    var cashback = 0
    var totalBonus = 0

    override fun getInfo() {
        println("Your money: $balance")
        println("Credit money: $creditMoney")
        println("Your bonuses: $totalBonus")
    }

    override fun deposit(i: Int) {
        val difference = creditLimit - creditMoney
        if (difference > 0) {
            val a = i - difference
            creditMoney += difference
            balance += a
            println("$a was deposited")
            totalDeposit += a
        } else if (difference == 0) {
            balance += i
            println("$i was deposited")
            totalDeposit += i
        }
        if (totalDeposit > 50000) {
            depositBonus = (i / 100) * 1
            totalBonus += depositBonus
        }   //Если общая сумма пополнений более 50т., то возвращается 1% от пополнений
        getInfo()
    }

    override fun pay(i: Int): Boolean {
        var result = true
        var price = i

        if (balance > i) {
            balance -= i
            println("$i was payed from deposit")
        } else if (balance == 0) {
            creditMoney -= i
            println("$i was payed from credit money")
        } else if (i < balance + creditMoney) {
            price -= balance
            println("$balance was payed from deposit")
            balance = 0
            creditMoney -= price
            println("$price was payed from credit money")
        } else {
            println("Not enough money!")
            result = false
        }
        if (result) {
            cashback = (i / 100) * 2                        //Кэшбек 2%
            balance += cashback
            totalBonus += cashback
        }
        getInfo()
        return result
    }
}