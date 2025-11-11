package lotto.domain

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class LottoTest {
    companion object {
        @JvmStatic
        fun invalidNumberLists() = listOf(
            Arguments.of(emptyList<Int>()),
            Arguments.of(listOf(1,2,3,4)),
            Arguments.of(listOf(1,2,3,4,5,6,7)),
            Arguments.of(listOf(1,1,3,4,5,6)),
            Arguments.of(listOf(1,1,3,4,5,50)),
        )
    }

    @ParameterizedTest
    @MethodSource("invalidNumberLists")
    @DisplayName("잘못된 로또들은 에러 발생")
    fun lottoExceptionTest(numbers: List<Int>) {
        assertThrows(IllegalArgumentException::class.java) {
            val lotto = Lotto(numbers)
        }
    }
}