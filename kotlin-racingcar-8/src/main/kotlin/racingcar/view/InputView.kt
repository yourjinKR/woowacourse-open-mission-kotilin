package racingcar.view

import camp.nextstep.edu.missionutils.Console
import racingcar.util.ErrorMessage

class InputView {
    fun askCarNames(): List<String> {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        return readTokens(ErrorMessage.INPUT_NAME_LIST)
    }

    fun askTryTurn(): Int {
        println("시도할 횟수는 몇 회인가요?")
        return readInt(ErrorMessage.INPUT_TRY_TURN)
    }

    fun readInt(errorMessage: ErrorMessage): Int {
        val input = Console.readLine()
        try {
            return input.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(errorMessage.msg)
        }
    }

    fun readTokens(errorMessage: ErrorMessage): List<String> {
        val input = Console.readLine()
        val tokens = input.split(",")
        try {
            validateTokens(tokens)
            return tokens
        } catch (e: IllegalArgumentException) {
            throw IllegalArgumentException(errorMessage.msg)
        }
    }

    fun validateTokens(tokens: List<String>?) {
        requireNotNull(tokens)
        require(tokens.isNotEmpty())

        for (token in tokens) {
            require(token.isNotEmpty())
        }
    }
}