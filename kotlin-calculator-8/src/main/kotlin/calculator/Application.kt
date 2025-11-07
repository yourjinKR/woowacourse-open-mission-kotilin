package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {
    // TODO: 프로그램 구현
    println("숫자 입력")
    val rawData = Console.readLine()

    val delimiterStrategies = listOf(
        DefaultDelimiterStrategy(),
        CustomDelimiterStrategy()
    )

    val delimiterStrategy = delimiterStrategies.find { delimiterStrategy -> delimiterStrategy.isSupport(rawData) }

    if (delimiterStrategy == null) {
        throw IllegalArgumentException("올바른 값을 입력해주세요")
    }

    val calcArea = delimiterStrategy.getCalcArea(rawData)
    val result = Calculator.sumStringList(calcArea)

    println(result)

    Console.close()
}