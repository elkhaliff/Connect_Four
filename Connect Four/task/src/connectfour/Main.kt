package connectfour

fun main() {

    println("Connect Four")

    val menu = Menu()
    menu.start()

    val game = ConnectFour(menu.firstPlayer, menu.secondPlayer, menu.rows, menu.cols)
    game.newGame()

    println(game)
}