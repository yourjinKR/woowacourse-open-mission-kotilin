package lotto.domain


enum class LottoRank(
    val matchedCount: Int,
    val isBonusMatched: Boolean,
    val prize: Int
) {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    NONE(0, false, 0);

    companion object {
        fun of(matchingResult: MatchingResult): LottoRank {
            val matchedCount = matchingResult.matchedCount
            val isBonusMatched = matchingResult.isBonusMatched

            val matchedRanks: List<LottoRank> = entries.filter { lottoRank -> lottoRank.matchedCount == matchedCount }

            return when (matchedRanks.size) {
                1 -> { matchedRanks[0] }
                2 -> { matchedRanks.filter { lottoRank -> lottoRank.isBonusMatched == isBonusMatched }[0] }
                else -> { LottoRank.NONE }
            }
        }
    }
}


fun main() {
    println(LottoRank.of(MatchingResult(1, false)))
}