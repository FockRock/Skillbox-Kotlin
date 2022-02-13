object Channels {
    private var channels: MutableList<String> = mutableListOf(
        "CartoonNetwork",
        "MTV",
        "HBO",
        "ComedyCentral",
        "National Geographic",
        "CNN",
        "Discovery"
    )

    fun getRandomChannels(n: Int): MutableList<String> {
        val mixed = channels.shuffled()
        val channelList: MutableList<String> = mutableListOf()

        var i = 0
        while (n != i) {
            channelList.add(mixed[i])
            i++
        }
        return channelList
    }
}