fun main() {

    val usdConverter: CurrencyConverter? = Converters.get("USD")
    val eurConverter: CurrencyConverter? = Converters.get("EUR")
    val gpdConverter: CurrencyConverter? = Converters.get("GPD")
    val uahConverter: CurrencyConverter? = Converters.get("UAH")

    if (usdConverter != null) {
        println("How much RUB you want to convert to ${usdConverter.currencyCode}")
        val i = readLine()?.toInt() ?:return
        println("$i RUB = ${usdConverter.convertToRub(i)} ${usdConverter.currencyCode}")
    }

    if (eurConverter != null) {
        println("How much RUB you want to convert to ${eurConverter.currencyCode}")
        val i = readLine()?.toInt() ?:return
        println("$i RUB = ${eurConverter.convertToRub(i)} ${eurConverter.currencyCode}")
    }

    if (gpdConverter != null) {
        println("How much RUB you want to convert to ${gpdConverter.currencyCode}")
        val i = readLine()?.toInt() ?:return
        println("$i RUB = ${gpdConverter.convertToRub(i)} ${gpdConverter.currencyCode}")
    }

    if (uahConverter != null) {
        println("How much RUB you want to convert to ${uahConverter.currencyCode}")
        val i = readLine()?.toInt() ?:return
        println("$i RUB = ${uahConverter.convertToRub(i)} ${uahConverter.currencyCode}")
    }
}