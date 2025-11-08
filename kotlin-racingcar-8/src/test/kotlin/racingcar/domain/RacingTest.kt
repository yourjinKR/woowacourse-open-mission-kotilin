import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import racingcar.domain.Car
import racingcar.domain.NumPicker
import racingcar.domain.Racing
import racingcar.util.ErrorMessage
import java.util.stream.Stream
import org.assertj.core.api.Assertions.*

@DisplayName("Racing 생성 검증")
class RacingTest {
    companion object {
        @JvmStatic
        fun racingInvalidCases(): Stream<Arguments> {
            return Stream.of(
                // cars 비어있음
                Arguments.arguments(emptyList<Car>(), 5, ErrorMessage.RACING_CARS_EMPTY.message),
                // totalTurn 최소 조건 미충족
                Arguments.arguments(listOf(Car("유어진")), 0, ErrorMessage.RACING_TURN_INVALID.message
                )
            )
        }
    }

    @ParameterizedTest(name = "[{index}] cars={0}, totalTurn={1} → message={2}")
    @MethodSource("racingInvalidCases")
    @DisplayName("예외 타입과 메시지를 함께 검증")
    fun invalidRacingTest(
        cars: List<Car>,
        totalTurn: Int,
        expectedMessage: String
    ) {
        assertThatThrownBy { Racing.carsTotalTurnOf(cars, totalTurn) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(expectedMessage)
    }

    // 숫자 뽑기 구현
    inner class NumPickerTest(): NumPicker {
        override fun pick(): Int {
            return 5;
        }
    }

    // 레이싱 세팅
    fun setRacing(): Racing {
        return Racing.carsTotalTurnOf(listOf(Car("유어진"), Car("오찬욱")), 5)
    }

    @Test
    @DisplayName("객체 프로퍼티와 복사본 주소값이 달라야 함")
    fun copySnapShotTest() {
        val racing = setRacing()
        val snapShot1 = racing.getCars()
        val snapshot2 = racing.getCars()

        assertThat(snapShot1 != snapshot2).isTrue
    }

    @Test
    @DisplayName("자동차 움직임 확인")
    fun carMoveTest() {
        val racing = setRacing()
        racing.processTurn(NumPickerTest())
        val racingCarShot = racing.getCars()
        val car = racingCarShot[0]

        assertThat(car.distance).isEqualTo(1)
    }

    @Test
    @DisplayName("자동차 다같이 움직이는지 확인")
    fun carsMoveTest() {
        val racing = setRacing()
        racing.processTurn(NumPickerTest())
        val racingCarShot = racing.getCars()
        val car1 = racingCarShot[0]
        val car2 = racingCarShot[1]
        val check = car1.distance == car2.distance

        assertThat(check).isTrue
    }
}