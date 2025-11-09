package racingcar.domain

import racingcar.util.ErrorMessage

class Car(name: String, distance: Int = 0) {
    companion object {
        const val NAME_MAX_LENGTH = 5

        fun copyOf(car: Car): Car {
            return Car(car.name, car.distance)
        }
    }
    val name: String
    var distance: Int = distance
        private set

    init {
        validateName(name)
        this.name = name
    }

    private fun validateName(name: String) {
        require(name.isNotBlank()) { ErrorMessage.CAR_NAME_EMPTY.message }
        require(name.length <= NAME_MAX_LENGTH) { ErrorMessage.CAR_NAME_LENGTH.message }
    }

    fun goForwardByPicker(numPicker: NumPicker) {
        val num = numPicker.pick()
        if (num >= 4) distance++
    }
}