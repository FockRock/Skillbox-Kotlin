fun main(args: Array<String>) {

    val firstName = "Nick"
    val lastName = "Smirnov"
    var height = 1.81
    val weight = 98.5f
    var isChild = height < 1.5 || weight < 40
    var info = """Name: $firstName
        |Last Name: $lastName
        |Height: $height m
        |Weight: $weight kg
        |Child: $isChild
    """.trimMargin()

    println(info)
    println()

    height = 1.4
    isChild = height < 1.5 || weight < 40

    info = """Name: $firstName
        |Last Name: $lastName
        |Height: $height m
        |Weight: $weight kg
        |Child: $isChild
    """.trimMargin()

    println(info)
}