package lotto.domain

import camp.nextstep.edu.missionutils.Randoms

class LottoNumbersPicker(): NumbersPicker {
    override fun pick(
        startInclusive: Int,
        endInclusive: Int,
        count: Int
    ): List<Int> {
        return Randoms.pickUniqueNumbersInRange(startInclusive, endInclusive, count)
    }
}