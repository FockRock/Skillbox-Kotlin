class SberCard : DebitCard() {

    init {
        println("Sber card was created!")
    }

    var totalDeposit = 0
    var depositBonus = 0
    var cashback = 0
    var totalBonus = 0

    override fun getInfo() {
        println("Your money: $balance")
        println("Your bonuses: $totalBonus")
    }

    override fun deposit(i: Int) {
        balance += i
        println("$i was deposited")
        totalDeposit += i
        if (totalDeposit > 30000) {
            depositBonus = (i / 100) * 5
            totalBonus += depositBonus
        }   //Если общая сумма пополнений более 50т., то возвращается 3% от пополнений
        getInfo()
    }

    override fun pay(i: Int): Boolean {
        val result: Boolean = if (balance > i) {
            balance -= i
            println("$i was payed")
            cashback = (i / 100) * 2                        //Кэшбек 1%
            balance += cashback
            totalBonus += cashback
            true
        } else {
            println("Not enough money!")
            false
        }
        getInfo()
        return result
    }
}