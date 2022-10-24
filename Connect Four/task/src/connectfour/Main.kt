package connectfour

fun main() {

    fun getString(vText: String): String {
        println(vText)
        return readLine()!!
    }

    println("Connect Four")
    val firstPlayer = getString("First player's name: ")
    val secondPlayer = getString("Second player's name: ")
    var test = false
    val game = ConnectFour()
    while (!test) {
        val strBoard = getString("Set the board dimensions (Rows x Columns)\n"+
                "Press Enter for default (6 x 7)")
        test = game.testData(strBoard
            .replace(" ", "")
            .replace("\t", "")
            .lowercase())
    }

    game.newGame(firstPlayer, secondPlayer)
    println(game)
}