fun main() {

    val usdConverter: CurrencyConverter? = Converters.get("USD")

    if (usdConverter != null) {
        println("How much RUB you want to convert to ${usdConverter.currencyCode}")
        val i = readLine()?.toInt() ?:return
        println("$i RUB = ${usdConverter.convertToRub(i)} ${usdConverter.currencyCode}")
    }

    val eurConverter: CurrencyConverter? = Converters.get("EUR")

    if (eurConverter != null) {
        println("How much RUB you want to convert to ${eurConverter.currencyCode}")
        val i = readLine()?.toInt() ?:return
        println("$i RUB = ${eurConverter.convertToRub(i)} ${eurConverter.currencyCode}")
    }

    val gpdConverter: CurrencyConverter? = Converters.get("GPD")

    if (gpdConverter != null) {
        println("How much RUB you want to convert to ${gpdConverter.currencyCode}")
        val i = readLine()?.toInt() ?:return
        println("$i RUB = ${gpdConverter.convertToRub(i)} ${gpdConverter.currencyCode}")
    }

    println("What currency you want to convert?")
    val currencyName = readLine().toString()
    val otherConverter: CurrencyConverter? = Converters.get(currencyName)

    if (otherConverter != null) {
        println("How much RUB you want to convert to ${otherConverter.currencyCode}")
        val i = readLine()?.toInt() ?:return
        println("$i RUB = ${otherConverter.convertToRub(i)} ${otherConverter.currencyCode}")
    }
}