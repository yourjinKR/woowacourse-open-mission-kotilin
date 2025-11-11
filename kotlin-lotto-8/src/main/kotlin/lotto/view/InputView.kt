package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.controller.dto.PurchaseRequest
import lotto.controller.dto.WinningRequest

class InputView {
    companion object {
        const val OFFICIAL_DELIMITER = ","
    }

    fun purchaseAmount(): PurchaseRequest {
        println("구입금액을 입력해 주세요.")
        val input = readInt()
        return PurchaseRequest(input)
    }

    fun winningLotto(): WinningRequest {
        println("당첨 번호를 입력해 주세요.")
        val winningNumbers = readIntToken()
        println("보너스 번호를 입력해 주세요.")
        val bonusNumber = readInt()

        return WinningRequest(
            winningNumbers=winningNumbers,
            bonusNumber=bonusNumber
        )
    }

    private fun readInt(): Int {
        val rawInput = Console.readLine()
        try {
            return rawInput.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("숫자를 입력하시오")
        }
    }

    private fun readIntToken(): List<Int> {
        val rawInput = Console.readLine()
        try {
            return rawInput.split(OFFICIAL_DELIMITER).map { str -> str.toInt() }
        } catch (e: Exception) {
            throw IllegalArgumentException("올바른 구분자(${OFFICIAL_DELIMITER})를 사용하여 숫자를 입력하시오")
        }
    }
}