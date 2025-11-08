package racingcar.view

import camp.nextstep.edu.missionutils.Console
import racingcar.controller.dto.CarSnapShot
import racingcar.controller.dto.RacingResponse
import racingcar.controller.dto.RacingSnapShot

class OutputView {
    fun printResult(response: RacingResponse) {
        val racingSnapShots = response.racingSnapShots
        val winners = response.winners

        val output = "\n실행 결과\n" +
                racingSnapShots.joinToString("") { racingSnapShot -> printRacingSnapShot(racingSnapShot) } +
                printWinners(winners)

        println(output)
        Console.close()
    }

    fun printRacingSnapShot(racingSnapShot: RacingSnapShot): String {
        val carSnapShots = racingSnapShot.cars

        var printedCars = ""

        carSnapShots.forEach { carSnapShot ->
            val printedCar = printCarSnapShot(carSnapShot)
            printedCars += printedCar
        }

        return printedCars + "\n"
    }


    fun printCarSnapShot(carSnapShot: CarSnapShot): String {
        val name = carSnapShot.name
        val distance = carSnapShot.distance
        val visualizedDistance = "-".repeat(distance)

        return "$name : ${visualizedDistance}\n"
    }

    fun printWinners(winners: List<String>): String {
        return "최종 우승자 ${winners.joinToString(", ")}"
    }
}