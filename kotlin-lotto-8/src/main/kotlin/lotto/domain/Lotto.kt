package lotto.domain

import camp.nextstep.edu.missionutils.Randoms
import lotto.exception.ErrorMessage

open class Lotto(numbers: List<Int>) {
    companion object {
        const val MAX_LENGTH = 6
        const val MIN_NUMBER = 1
        const val MAX_NUMBER = 45
    }

    val numbers: List<Int>
        get() = field.toList()

    init {
        require(numbers.size == MAX_LENGTH) { ErrorMessage.LOTTO_NUMBERS_LENGTH.message }
        require(numbers.toSet().size == numbers.size) { ErrorMessage.LOTTO_NUMBERS_DUPLICATE.message }
        numbers.forEach {
            number -> require(number in MIN_NUMBER..MAX_NUMBER) { ErrorMessage.LOTTO_NUMBERS_RANGE.message }
        }
        this.numbers = numbers
    }
}

fun main() {
}