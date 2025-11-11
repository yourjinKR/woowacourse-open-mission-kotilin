package lotto.domain

import lotto.exception.ErrorMessage

class LottoGame(val picker: NumbersPicker) {
    companion object {
        const val PRICE = 1000
    }

    fun pickLottoByPickRule(): Lotto {
        val numbers = picker.pick(
            Lotto.MIN_NUMBER,
            Lotto.MAX_NUMBER,
            Lotto.MAX_LENGTH)
        return Lotto(numbers)
    }

    fun purchaseLottoTickets(purchaseAmount: Int): Int {
        val ticket = purchaseAmount / PRICE
        require(ticket != 0) { ErrorMessage.INVALID_PURCHASE.message }
        require(purchaseAmount % PRICE == 0) { ErrorMessage.INVALID_PURCHASE.message }
        return ticket
    }

    fun getMappedMatchingResult(winningLotto: WinningLotto, lottoList: List<Lotto>): Map<LottoRank, Int> {
        val matchingResults: List<MatchingResult> = lottoList.map { lotto ->
            winningLotto.compareToLotto(lotto)
        }

        val matchedRanks: List<LottoRank> = matchingResults.map { matchingResult ->
            LottoRank.of(matchingResult)
        }

        val matchedGroupBy = matchedRanks.groupingBy { it }.eachCount()

        val matchedRankCountMap: Map<LottoRank, Int> = LottoRank.entries
            .filter { it != LottoRank.NONE }
            .associateWith { rank -> matchedGroupBy[rank] ?: 0 }

        return matchedRankCountMap
    }

    fun getYield(lottoList: List<Lotto>, mappedMatchingResult :Map<LottoRank, Int>): Double {
        val yield: Double = mappedMatchingResult.filter { (key, value) -> value != 0 }
            .map { (key, value) -> key.prize * value }
            .sum()
            .toDouble() / lottoList.size

        return yield * 100
    }
}