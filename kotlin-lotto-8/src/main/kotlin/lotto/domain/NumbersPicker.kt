package lotto.domain

interface NumbersPicker {
    fun pick(startInclusive: Int, endInclusive: Int, count: Int): List<Int>
}