package connectfour

/**
 * Символы границ ячеек
 */
const val VERT_BOARD = "║"
const val DOWN_BOARD = "═"
const val LEFT_CORNER = "╚"
const val RIGHT_CORNER = "╝"
const val MIDDLE_CORNER = "╩"

const val SPACE_CELL = " " // незанятая ячейка

data class Board(val rows: Int, val cols: Int) {

    private var fieldMap: Array<Array<String>> = Array(rows) { Array(cols) { SPACE_CELL } }

    override fun toString(): String {
        var n = 0
        var mapString = SPACE_CELL + Array(cols) { ++n }.joinToString(SPACE_CELL) + "\n"
        fieldMap.forEachIndexed { _, r -> // строка row
            mapString += VERT_BOARD
            r.forEachIndexed { _, c -> // колонка col
                mapString += c + VERT_BOARD
            }
            mapString += "\n"
        }
        mapString += LEFT_CORNER + Array(cols) { DOWN_BOARD }.joinToString(MIDDLE_CORNER) + RIGHT_CORNER + "\n"
        return mapString
    }
}
