package connectfour

const val DEFAULT_ROWS = 6
const val DEFAULT_COLS = 7
const val MIN_VALUE = 5
const val MAX_VALUE = 9

class ConnectFour {
    private lateinit var firstPlayer: String
    private lateinit var secondPlayer: String
    private lateinit var board: Board
    private var rows = 0
    private var columns = 0

    private fun range(i: Int) = i in MIN_VALUE..MAX_VALUE

    fun testData(input: String?) : Boolean {
        if (input.isNullOrEmpty()) {
            rows = DEFAULT_ROWS
            columns = DEFAULT_COLS
            return true
        } else {
            try {
                val (a, b) = input.split("x")
                rows = a.toInt()
                columns = b.toInt()
                if (!range(rows)) {
                    println("Board rows should be from 5 to 9")
                    return false
                }
                if (!range(columns)) {
                    println("Board columns should be from 5 to 9")
                    return false
                }
                return true
            } catch (e : java.lang.Exception) {
                println("Invalid input")
                return false
            }
        }
    }

    fun newGame(firstPlayer: String, secondPlayer: String) {
        this.firstPlayer = firstPlayer
        this.secondPlayer = secondPlayer
        board = Board(rows, columns)
    }

    override fun toString(): String {
        return "$firstPlayer vs $secondPlayer\n" +
            board.toString()
    }
}