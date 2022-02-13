class Tv (
    val brand: String,
    val model: String,
    val diagonal: String
) {

    var turnOn = false
        private set

    var volume = 10
        private set

    var cN = 0
    private var channelList: MutableList<String> = mutableListOf()

    init {
        println("Введите количество каналов для настройки:")
        val cN = readln().toInt()
        channelList = Channels.getRandomChannels(cN)
        Thread.sleep(1000)
    }

    private val channelsCount = channelList.size - 1

    fun turnOn() {
        if (!turnOn) {
            Thread.sleep(1000)
            turnOn = true
            println("Tv is on!")
        }
    }

    fun turnOnChannel() {
        println("What channel do you want?")
        val i = readLine()?.toInt()?:return
        if (!turnOn) turnOn()
        cN = i-1
        println("Tv switched to ${channelList[cN]}")
    }

    fun channelChangeUp() {
        if (!turnOn) {
            turnOn()
            println("Tv turned on at ${channelList[cN]}")
        }
        if (cN != channelsCount) {
            cN++
            Thread.sleep(1000)
            println("Tv switched to ${channelList[cN]}")
        } else {
            cN = 0
            Thread.sleep(1000)
            println("Tv switched to ${channelList[cN]}")
        }
    }

    fun channelChangeDown() {
        if (!turnOn) {
            turnOn()
            println("Tv turned on at ${channelList[cN]}")
        }
        if (cN != 0) {
            Thread.sleep(1000)
            cN--
            println("Tv switched to ${channelList[cN]}")
        } else {
            Thread.sleep(1000)
            cN = channelsCount
            println("Tv switched to ${channelList[cN]}")
        }
    }

    fun volumeUp() {
        if (turnOn){
            println("How much louder?")
            val i = readLine()?.toInt()?:return
            var n = 0
            if (volume < maxVolume) {
                while (n != i) {
                    Thread.sleep(1000)
                    volume++
                    println("volume is $volume")
                    n++
                }
            } else println("Volume is maximum!")
        } else println("Turn on TV!")
    }

    fun volumeDown() {
        if (turnOn){
            println("How much quieter?")
            val i = readLine()?.toInt()?:return
            var n = 0
            if (volume > 0) {
                while (i != n) {
                    Thread.sleep(1000)
                    volume--
                    println("volume is $volume")
                    n++
                }
            } else println("Mute!")
        } else println("Turn on TV!")
    }

    companion object {
        var maxVolume = 100
    }
}