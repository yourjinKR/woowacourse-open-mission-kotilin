package lotto.controller.dto

data class MatchingResponse(
    val matchedCount: Int,
    val isBonusMatched: Boolean,
    val prize: Int,
    val winningCount: Int
)
