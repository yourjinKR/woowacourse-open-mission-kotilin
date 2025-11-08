package racingcar.domain

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.provider.Arguments
import java.util.stream.Stream

class CarTest {

    @Test
    @DisplayName("차 이름 확인")
    fun carNameTest() {
        val car = Car("유어진")
        assertThat(car.name)
            .isEqualTo("유어진")

        assertThat(car.name)
            .isNotEqualTo("유어진123")
    }

    @Test
    @DisplayName("차 이름이 5글자면 에러 발생")
    fun invalidCarNameTest() {
        assertThrows<IllegalArgumentException> { Car("11111111111111") }
    }

    @Test
    @DisplayName("차 이름이 비어 있으면 에러 발생")
    fun blankCarNameTest() {
        assertThrows<IllegalArgumentException> { Car("") }
    }
}