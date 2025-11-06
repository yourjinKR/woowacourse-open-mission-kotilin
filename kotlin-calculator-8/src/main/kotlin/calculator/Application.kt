package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {
    // TODO: 프로그램 구현
    val input = Console.readLine()
//    val input = "//;\\n1;2,3"
    var delimiter = ",:"
    println(input)

    // 커스텀 구분자 있는지 확인
    val regex = "^//.\\\\n.*".toRegex()
    val isCustom = regex.matches(input)
    println(isCustom)

    // 커스텀 구분자에 구분자 목록 등록
    if (isCustom) {
        val header = input.substring(0, 5)
        val customDelimiter = header[2]
        delimiter += customDelimiter
    }

    // 구분자로 문자열 나눔
    val delimiterRegex = "[${Regex.escape(delimiter)}]".toRegex()
    val numList = input.substring(5).split(delimiterRegex)
    println(numList)

    val aa = "1,2,3"
    val bb = aa.split(",")
    println(bb)
    val aa2 = "1,2:3"
    val bb2 = aa2.split(",", ":")
    println(bb2)

    var parsedNumList = mutableListOf<Int>()
    // 문자열 나눈 후 INT 형변환
    numList.forEach { string ->
        val parsedString = string.toInt()
        println(parsedString)
        parsedNumList.add(parsedString)
    }

    val total = parsedNumList.sum()
    println(total)

    // map + 함수 콤보
    val total2 = numList.map { it.toInt() }.sum()
    println(total2)

    // 심지어 sumOf도 있음 : 대충 sum을 할건데 요로케 하겠다
    val total3 = numList.sumOf { it.toInt() }
    println(total3)
}
