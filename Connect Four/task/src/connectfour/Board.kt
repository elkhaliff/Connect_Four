package connectfour

data class Board(val rows: Int, val columns: Int) {

    override fun toString(): String {
        return "$rows x $columns board"
    }
}
