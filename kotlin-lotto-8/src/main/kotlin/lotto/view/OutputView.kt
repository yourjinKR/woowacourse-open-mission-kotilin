package lotto.view

import lotto.controller.dto.LottoResponse
import lotto.controller.dto.MatchingResponse
import lotto.controller.dto.PurchaseResponse
import lotto.controller.dto.WinningResponse

class OutputView {
    fun purchaseResult(response: PurchaseResponse) {
        val amountMention = "${response.amount}개를 구입했습니다.\n"
        val lottoList = response.lottoList.joinToString("\n") {
            lottoResponse -> lottoResult(lottoResponse)
        }

        println(amountMention + lottoList + "\n")
    }

    private fun lottoResult(response: LottoResponse): String {
        return response.numbers.sorted().toString()
    }

    fun winningResult(response: WinningResponse) {
        val matchingListMention = response.matchingList.joinToString("\n") {
            matchingResponse -> matchingResult(matchingResponse)
        }
        val yieldMention = "총 수익률은 ${response.yield}%입니다."

        println(matchingListMention + "\n" + yieldMention)
    }

    fun matchingResult(response: MatchingResponse): String {
        val countMention = "${response.matchedCount}개 일치"
        val isBonusMention = if (response.isBonusMatched) ", 보너스 볼 일치" else ""
        val prizeMention = "(${response.prize}원)"
        val winningCountMention = "- ${response.winningCount}개"

        return "${countMention}${isBonusMention} $prizeMention $winningCountMention"
    }
}