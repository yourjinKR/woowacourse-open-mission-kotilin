package lotto.domain

import lotto.exception.ErrorMessage

class WinningLotto(numbers: List<Int>, bonusNumber: Int): Lotto(numbers) {

    val bonusNumber: Int

    init {
        require(bonusNumber in MIN_NUMBER..MAX_NUMBER) { ErrorMessage.LOTTO_BONUS_NUMBER_RANGE.message }
        this.bonusNumber = bonusNumber
    }

    fun compareToLotto(lotto: Lotto): MatchingResult {
        val lottoNumbers = lotto.numbers
        val union = numbers + lottoNumbers
        val matchedCount = union.groupBy { it }.filter { it.value.size > 1 }.flatMap { it.value }.distinct().count()
        val isBonusMatched = lottoNumbers.contains(bonusNumber)

        return MatchingResult(
            matchedCount=matchedCount,
            isBonusMatched=isBonusMatched
        )
    }
}