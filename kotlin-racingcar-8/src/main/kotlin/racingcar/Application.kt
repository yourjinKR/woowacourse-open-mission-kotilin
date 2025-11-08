package racingcar

import racingcar.controller.RacingController
import racingcar.domain.RacingMapper
import racingcar.domain.RandomNumPicker
import racingcar.service.RacingService
import racingcar.view.InputView
import racingcar.view.OutputView

fun main() {
    val racingController = RacingController(InputView(), OutputView(), RacingService(
        RandomNumPicker(), RacingMapper()
    ))
    racingController.run()
}
