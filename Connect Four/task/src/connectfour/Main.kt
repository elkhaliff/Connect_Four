package connectfour

fun main() {

    println("Connect Four")

    val inData = InputData()
    inData.make()

    val connectFour = ConnectFour(inData)
    connectFour.newGame()
    println(connectFour)

    connectFour.game()
}