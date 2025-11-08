package racingcar.controller

import racingcar.controller.dto.RacingRequest
import racingcar.service.RacingService
import racingcar.view.InputView
import racingcar.view.OutputView

class RacingController(val inputView: InputView, val outputView: OutputView, val racingService: RacingService) {

    fun run() {
        val names = inputView.askCarNames()
        val totalTurn = inputView.askTryTurn()

        val request = RacingRequest(names, totalTurn)
        val response = racingService.processRacing(request)

        outputView.printResult(response)
    }

}