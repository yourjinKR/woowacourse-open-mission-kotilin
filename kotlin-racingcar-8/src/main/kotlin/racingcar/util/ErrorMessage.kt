package racingcar.util

import racingcar.domain.Car
import racingcar.domain.Racing

// TODO : 에러 메세지 헤더 설정
enum class ErrorMessage(val message: String) {
    INPUT_NAME_LIST("자동차의 이름은 쉼표(,)로 구분하여 입력하시오"),
    INPUT_TRY_TURN("시도 횟수는 최소 ${Racing.TURN_MINIMUM}이상 입력하시오"),

    CAR_NAME_EMPTY("자동차의 이름은 비어 있을 수 없습니다"),
    CAR_NAME_LENGTH("자동차의 이름은 최대 ${Car.NAME_MAX_LENGTH}글자 입니다"),

    RACING_CARS_EMPTY("경주에는 최소 하나의 자동차가 있어야 합니다."),
    RACING_TURN_INVALID("레이싱 시도 횟수 기회는 최소 ${Racing.TURN_MINIMUM}번입니다")
}