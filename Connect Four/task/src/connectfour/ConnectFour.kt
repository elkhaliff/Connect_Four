package connectfour

import java.lang.Exception
import kotlin.system.exitProcess

const val EXIT_GAME = "end"

/**
 * Статус завершения хода
 */
//const val STAT_DRAW = -10 // всё поле заполнено - ничья
const val STAT_FULL = -5 // колонка заполнена
const val STAT_OVER = - 3 // запрашиваемое число не входит в диапазон столбцов
const val STAT_NOT_MADE = -2 // ход не сделан
const val STAT_EXIT = -1 // выход
//const val STAT_WIN_FIRST = 0 // выиграл первый игрок
//const val STAT_WIN_SECOND = 1 // выиграл второй игрок
const val STAT_OK = 2 // ход сделан


class ConnectFour(private val inData: InputData) {

    private lateinit var board: Board
    private var currColumn = 0

    fun newGame() {
        board = Board(inData)
    }

    override fun toString(): String {
        return "${inData.players[FIRST_PLAYER]} VS ${inData.players[SECOND_PLAYER]}\n" +
                "${inData.rows} x ${inData.cols} board\n" +
                board.toString()
    }

    /**
     * Делаем ходы до посинения (либо когда будет введен EXIT_GAME, либо когда заполнится поле, либо до выигрыша)
     */
    fun game() {
        var playerId = FIRST_PLAYER
        var statTurn: Int
        do {
            statTurn = doTurn(playerId)
            when (statTurn) {
                STAT_OK -> {
                    println(board) // распечатываем текущее состояние игрового поля
                    playerId = kotlin.math.abs(playerId - 1) // смена игрока
                }
                STAT_FULL -> println("Column $currColumn is full")
                STAT_EXIT -> {
                    println("Game over!")
                    exitProcess(0)
                }
                STAT_NOT_MADE -> println("Incorrect column number")
                STAT_OVER -> println("The column number is out of range (1 - ${inData.cols})")
                else -> println("unknown status")
            }
        } while (true)
    }

    /**
     * Делаем ход игроком (если введен EXIT_GAME - неможем делать ход, возвращаем false)
     */
    private fun doTurn(playerId: Int): Int {
        val strTurn = inData.getAction(playerId)
        if (strTurn == EXIT_GAME) return STAT_EXIT
        try {
            currColumn = strTurn.toInt()
            if (currColumn !in 1 .. inData.cols) return STAT_OVER
            if (board.put(playerId, currColumn)) return STAT_OK
            return STAT_FULL
        } catch (e: Exception) {
            return STAT_NOT_MADE
        }
    }
}