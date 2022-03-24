class Exept {
    class TooHighPressure: Throwable("Pressure is too high!")

    class TooLowPressure: Throwable("Pressure is too low!")

    class IncorrectPressure: Throwable("Pressure is incorrect!")
}