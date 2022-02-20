abstract class DebitCard : BankCard() {
    override fun deposit(i: Int) {
        super.deposit(i)
    }

    override fun getBalance() {
        println("Balance on Debit Card: $balance")
    }
}