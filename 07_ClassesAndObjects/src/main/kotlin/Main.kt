fun main() {
    val sony = Tv("Sony", "S124", "55")

    sony.turnOn()
    sony.turnOnChannel()
    sony.channelChangeUp()
    sony.channelChangeDown()
    sony.volumeUp()
    sony.volumeDown()

    val samsung = Tv("Samsung", "M80", "45")
    samsung.turnOn()
    samsung.turnOnChannel()
    samsung.channelChangeUp()
    samsung.channelChangeDown()
    samsung.volumeUp()
    samsung.volumeDown()

    val phillips = Tv("Phillips", "H097", "50")
    phillips.turnOn()
    phillips.turnOnChannel()
    phillips.channelChangeUp()
    phillips.channelChangeDown()
    phillips.volumeUp()
    phillips.volumeDown()
}