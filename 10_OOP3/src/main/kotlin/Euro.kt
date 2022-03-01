class Euro: CurrencyConverter {
    override val currencyCode: String = "EUR"

    override fun convertToRub(i: Int): Double {
        return i.toFloat()/93.6
    }
}