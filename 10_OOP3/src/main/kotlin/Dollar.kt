class Dollar: CurrencyConverter {
    override val currencyCode: String = "USD"

    override fun convertToRub(i: Int): Double {
        return i.toFloat()/83.55
    }
}