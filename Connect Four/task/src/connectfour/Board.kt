package connectfour

/**
 * Символы границ ячеек
 */
const val VERT_BOARD = "║"
const val DOWN_BOARD = "═"
const val LEFT_CORNER = "╚"
const val RIGHT_CORNER = "╝"
const val MIDDLE_CORNER = "╩"

/**
 * Маркеры поля
 */
const val SPACE_CELL = " " // незанятая ячейка
const val FIRST_CELL = "o" // занято первым игроком
const val SECOND_CELL = "*" // занято вторым игроком
val markers = arrayOf(FIRST_CELL, SECOND_CELL)


data class Board(val inData: InputData) {

    private var fieldMap: Array<Array<String>> = Array(inData.rows) { Array(inData.cols) { SPACE_CELL } }

    /**
     * Получение строки и столбца
     */
    //private fun getRow(row: Int) = fieldMap[row].joinToString { "" }
    private fun getCol(col: Int): String {
        var str = ""
        for (row in 0 until inData.rows)  str += fieldMap[row][col]
        return str
    }
    /**
     * Проверка на заполненность всего столбца
     */
    private fun isFull(col: Int) =!getCol(col).contains(SPACE_CELL)

    /**
     * Проверка на незаполненность
     */
    private fun isEmpty(row: Int, col: Int) = (fieldMap[row][col] == SPACE_CELL)

    /**
     * Получение последней незаполненной ячейки столбца (или null)
     */
    private fun getLastEmpty(col: Int): Int? {
        if (isFull(col)) return null

        for (r in inData.rows - 1 downTo 0) {
            if (isEmpty(r, col)) {
                return r
            }
        }
        return null
    }

    /**
     * Установка значения в столбец (если нет возможности возвращаяется false)
     */
    fun put(playerId: Int, col_: Int): Boolean {
        val col = col_ - 1
        val row: Int? = getLastEmpty(col)
        if (row != null) {
            fieldMap[row][col] = markers[playerId]
            return true
        }
        return false
    }


    override fun toString(): String {
        var n = 0
        var mapString = SPACE_CELL + Array(inData.cols) { ++n }.joinToString(SPACE_CELL) + "\n"
        fieldMap.forEachIndexed { _, r -> // строка row
            mapString += VERT_BOARD
            r.forEachIndexed { _, c -> // колонка col
                mapString += c + VERT_BOARD
            }
            mapString += "\n"
        }
        mapString += LEFT_CORNER + Array(inData.cols) { DOWN_BOARD }.joinToString(MIDDLE_CORNER) + RIGHT_CORNER
        return mapString
    }
}