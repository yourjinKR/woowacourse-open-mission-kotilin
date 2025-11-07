package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {
    // TODO: 프로그램 구현
    println("숫자 입력")
    val rawData = Console.readLine()

    val hasCustomDelimiter = hasCustomDelimiter(rawData)
    println("결과")

    if (hasCustomDelimiter) {
        val customDelimiter = CustomDelimiter(rawData)
        val numList = customDelimiter.splitByDelimiter()
        println(Calculator.sumStringList(numList))
    }
    if (!hasCustomDelimiter) {
        val defaultDelimiter = DefaultDelimiter(rawData)
        val numList = defaultDelimiter.splitByDelimiter()
        println(Calculator.sumStringList(numList))
    }

    Console.close()
}

// 커스텀 구분자 있는지 확인
fun hasCustomDelimiter(input: String): Boolean {
    val regex = "^//.\\\\n.*".toRegex()
    return input.matches(regex)
}