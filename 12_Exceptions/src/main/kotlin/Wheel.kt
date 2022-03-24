class Wheel(
    var pressure: Double
) {
    fun pumpPressure(pressureToPump: Double): Double  {
        pressure = pressureToPump
        return pressure
    }

    fun checkPressure (pres: Double) {
        if (pres in 1.6..2.5) {
            println("Pressure is good, and it is $pres atmosphere")
        } else if (pres > 2.5 && pres < 10) {
            throw Exept.TooHighPressure()
        } else if (pres > 0 && pres < 1.6) {
            throw Exept.TooLowPressure()
        } else throw Exept.IncorrectPressure()
    }
}