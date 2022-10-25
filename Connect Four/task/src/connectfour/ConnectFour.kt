package connectfour

class ConnectFour(val firstPlayer: String, val secondPlayer: String, val rows: Int, val cols: Int) {

    private lateinit var board: Board

    fun newGame() {
        board = Board(rows, cols)
    }

    override fun toString(): String {
        return "$firstPlayer VS $secondPlayer\n" +
                "$rows x $cols board\n" +
                board.toString()
    }
}