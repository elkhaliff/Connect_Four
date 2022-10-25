package connectfour

/**
 * Размеры по умолчанию и граничные
 */
const val DEFAULT_ROWS = 6
const val DEFAULT_COLS = 7
const val MIN_VALUE = 5
const val MAX_VALUE = 9

class Menu {
    var rows = DEFAULT_ROWS
    var cols = DEFAULT_COLS

    var firstPlayer = ""
    var secondPlayer = ""

    private fun getString(vText: String): String {
        println(vText)
        return readLine()!!
    }

    private fun requiredSize(i: Int) = i in MIN_VALUE..MAX_VALUE

    /**
     * Проверка полученных размеров поля
     */
    private fun testData(input: String?) : Boolean {
        if (input.isNullOrEmpty()) {
            rows = DEFAULT_ROWS
            cols = DEFAULT_COLS
            return true
        } else {
            try {
                val (a, b) = input.split("x")
                rows = a.toInt()
                cols = b.toInt()
                if (!requiredSize(rows)) {
                    println("Board rows should be from 5 to 9")
                    return false
                }
                if (!requiredSize(cols)) {
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


    fun start() {
        /**
         * Игроки
         */
        firstPlayer = getString("First player's name: ")
        secondPlayer = getString("Second player's name: ")

        /**
         * Игровое поле
         */
        var test = false
        while (!test) {
            val strBoard = getString(
                "Set the board dimensions (Rows x Columns)\n" +
                        "Press Enter for default (6 x 7)"
            )
            test = testData(
                strBoard
                    .replace(" ", "")
                    .replace("\t", "")
                    .lowercase()
            )
        }
    }

}