class Pound: CurrencyConverter {
    override val currencyCode: String = "GPD"

    override fun convertToRub(i: Int): Double {
        return i.toFloat()/102.4
    }
}