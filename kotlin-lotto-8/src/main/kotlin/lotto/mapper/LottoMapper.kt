package lotto.mapper

import lotto.controller.dto.LottoResponse
import lotto.controller.dto.MatchingResponse
import lotto.controller.dto.PurchaseResponse
import lotto.controller.dto.WinningResponse
import lotto.domain.Lotto
import lotto.domain.LottoRank

class LottoMapper {
    fun toDto(lottoList: List<Lotto>): PurchaseResponse {
        return PurchaseResponse(
            amount = lottoList.size,
            lottoList = lottoList.map { lotto -> toDto(lotto) }
        )
    }

    private fun toDto(lotto: Lotto): LottoResponse {
        return LottoResponse(
            numbers = lotto.numbers
        )
    }

    fun toDto(mappedMatchingResult: Map<LottoRank, Int>, yield: Double): WinningResponse {
        val matchingList = mappedMatchingResult.map { (key, value) ->
            toDto(key, value)
        }

        return WinningResponse(
            matchingList = matchingList,
            yield = yield
        )
    }

    private fun toDto(lottoRank: LottoRank, winningCount: Int): MatchingResponse {
        return MatchingResponse(
            matchedCount = lottoRank.matchedCount,
            isBonusMatched = lottoRank.isBonusMatched,
            prize = lottoRank.prize,
            winningCount = winningCount
        )
    }
}