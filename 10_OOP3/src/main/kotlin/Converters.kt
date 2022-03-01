import java.util.*

object Converters{
    private val converterMap = mapOf("EUR" to Euro(), "USD" to Dollar(), "GPD" to Pound())

    fun get(currencyCodes: String): CurrencyConverter? {
        val i = currencyCodes.uppercase()

        return if (i in converterMap) {
            converterMap[i]
        } else object : CurrencyConverter {
            override val currencyCode: String = i
            override fun convertToRub(i: Int): Double {
                println("How much RUB does $currencyCode cost?")
                val cost = readLine()!!.toDouble()
                return i/ cost
            }
        }
    }
}