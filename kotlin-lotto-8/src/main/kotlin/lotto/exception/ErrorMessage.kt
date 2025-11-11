package lotto.exception

import lotto.domain.Lotto
import lotto.domain.LottoGame


enum class ErrorMessage(private val rawMessage: String) {
    LOTTO_NUMBERS_LENGTH("로또의 최대 숫자 길이는 ${Lotto.MAX_LENGTH}입니다."),
    LOTTO_NUMBERS_DUPLICATE("로또 번호 내 숫자 중 중복이 있습니다."),
    LOTTO_NUMBERS_RANGE("로또 번호는 ${Lotto.MIN_NUMBER}와 ${Lotto.MAX_NUMBER} 사이 숫자만 가능합니다."),
    LOTTO_BONUS_NUMBER_RANGE("보너스 번호는 ${Lotto.MIN_NUMBER}와 ${Lotto.MAX_NUMBER} 사이 숫자만 가능합니다."),
    INVALID_PURCHASE("올바르지 않은 구입금액 입니다.")
    ;

    private val prefix = "[ERROR]"
    val message: String
        get() = "$prefix $rawMessage"
}