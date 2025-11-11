package lotto.controller.dto

data class WinningResponse (
    val matchingList: List<MatchingResponse>,
    val yield: Double
)