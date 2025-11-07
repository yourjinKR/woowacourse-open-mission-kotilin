package racingcar.util

import racingcar.domain.Car

enum class ErrorMessage(val message: String) {
    CAR_NAME_EMPTY("자동차의 이름은 비어 있을 수 없습니다"),
    CAR_NAME_LENGTH("자동차의 이름은 최대 ${Car.NAME_MAX_LENGTH}글자 입니다")
}