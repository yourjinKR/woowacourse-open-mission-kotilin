package racingcar.domain

import racingcar.util.ErrorMessage

class Car(name: String) {
    companion object {
        const val NAME_MAX_LENGTH = 5

        fun copyOf(car: Car): Car {
            return Car(car.name)
        }
    }

    init { validateName(name) }

    val name: String = name
    var distance: Int = 0

    private fun validateName(name: String) {
        require(name.isNotBlank()) { ErrorMessage.CAR_NAME_EMPTY.message }
        require(name.length <= NAME_MAX_LENGTH) { ErrorMessage.CAR_NAME_LENGTH.message }
    }

    fun goForwardByPicker(numPicker: NumPicker) {
        val num = numPicker.pick()
        if (num >= 4) distance++
    }
}