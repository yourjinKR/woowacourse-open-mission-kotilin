package racingcar.domain

import racingcar.util.ErrorMessage

// TODO : 테스트 필요
class Racing private constructor(private val cars: List<Car>, val totalTurn: Int) {
    companion object {
        const val TURN_MINIMUM = 1

        fun carsTotalTurnOf(cars: List<Car>, totalTurn: Int): Racing {
            validateCars(cars)
            validateTotalTurn(totalTurn)
            return Racing(cars, totalTurn)
        }

        private fun validateCars(cars: List<Car>) {
            if (cars.isEmpty())
                throw IllegalArgumentException(ErrorMessage.RACING_CARS_EMPTY.message)
        }

        private fun validateTotalTurn(totalTurn: Int) {
            if (totalTurn < TURN_MINIMUM)
                throw IllegalArgumentException(ErrorMessage.RACING_TURN_INVALID.message)
        }
    }

    var nowTurn: Int = 1
        private set

    fun processTurn(numPicker: NumPicker) {
        cars.forEach { car -> car.goForwardByPicker(numPicker) }
        nowTurn++
    }

    fun getCars(): List<Car> {
        return cars.map { car -> Car.copyOf(car) }
    }
}