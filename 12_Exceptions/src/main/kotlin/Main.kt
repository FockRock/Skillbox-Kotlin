fun main() {
    val wheel = Wheel(2.0)

    try {
        wheel.pumpPressure(1.0)
        wheel.checkPressure(wheel.pressure)
    } catch (e: Exept.TooHighPressure) {
        println(Exept.TooHighPressure().message)
    } catch (e: Exept.TooLowPressure) {
        println(Exept.TooLowPressure().message)
    } catch (e: Exept.IncorrectPressure){
        println(Exept.IncorrectPressure().message)
    }
}