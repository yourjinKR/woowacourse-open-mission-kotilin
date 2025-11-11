package lotto.domain

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class WinningLottoTest {
    companion object {
        @JvmStatic
        fun invalidArguments() = listOf(
            Arguments.of(emptyList<Int>(), 5),
            Arguments.of(listOf(1, 2, 3, 4), 5),
            Arguments.of(listOf(1, 2, 3, 4, 5, 6, 7), 5),
            Arguments.of(listOf(1, 1, 3, 4, 5, 6), 5),
            Arguments.of(listOf(1, 1, 3, 4, 5, 50), 5),
            Arguments.of(listOf(1, 1, 3, 4, 5, 6), 100),
        )
    }

    @ParameterizedTest
    @MethodSource("invalidArguments")
    @DisplayName("잘못된 로또들은 에러 발생")
    fun winningLottoExceptionTest(numbers: List<Int>, bonusNumber: Int) {
        assertThrows(IllegalArgumentException::class.java) {
            val lotto = WinningLotto(numbers, bonusNumber)
        }
    }

    @Test
    fun compareToLottoTest() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 7))
        val winningLotto = WinningLotto(listOf(1, 2, 3, 4, 5, 6), 1)
        assertEquals(5, winningLotto.compareToLotto(lotto))
    }

}