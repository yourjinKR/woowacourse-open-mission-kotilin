package lotto.controller.dto

data class WinningRequest(
    val winningNumbers: List<Int>,
    val bonusNumber: Int
)