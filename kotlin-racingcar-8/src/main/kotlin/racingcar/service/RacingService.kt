package racingcar.service

import racingcar.controller.dto.CarSnapShot
import racingcar.controller.dto.RacingRequest
import racingcar.controller.dto.RacingResponse
import racingcar.controller.dto.RacingSnapShot
import racingcar.domain.CarFactory
import racingcar.domain.Racing
import racingcar.domain.RacingMapper
import racingcar.domain.RandomNumPicker

class RacingService(val numPicker: RandomNumPicker, val mapper: RacingMapper) {

    fun processRacing(request: RacingRequest): RacingResponse {
        val names = request.names

        val cars = CarFactory.createNamesFrom(names)
        val totalTurn = request.totalTurn

        val racing = Racing.carsTotalTurnOf(cars, totalTurn)

        val iter = arrayOf(racing.nowTurn..racing.totalTurn)

        val racingSnapShots = List(totalTurn) { processTurn(racing) }
        val winners = pickWinners(racing)

        return RacingResponse(racingSnapShots, winners)
    }

    fun processTurn(racing: Racing): RacingSnapShot {
        racing.processTurn(numPicker)
        val cars = racing.getCars()
        val carSnapShots = mapper.toDto(cars)
        return RacingSnapShot(carSnapShots)
    }

    fun pickWinners(racing: Racing): List<String> {
        val cars = racing.getCars()
        val winnableDistance = cars.maxOfOrNull { it.distance }
        return cars.filter { car -> car.distance == winnableDistance } .map { car -> car.name }
    }
}