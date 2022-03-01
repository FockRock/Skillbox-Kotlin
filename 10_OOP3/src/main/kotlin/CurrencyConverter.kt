interface CurrencyConverter {
    val currencyCode: String

    fun convertToRub(i: Int): Double
}