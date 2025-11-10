package lotto.domain

import lotto.exception.ErrorMessage

open class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { ErrorMessage.LOTTO_NUMBERS_LENGTH.message }
    }
}