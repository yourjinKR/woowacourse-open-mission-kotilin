package racingcar.domain

import racingcar.util.ErrorMessage

class Car(val name: String, var distance: Int = 0) {
    companion object {
        const val NAME_MAX_LENGTH = 5

        fun copyOf(car: Car): Car {
            return Car(car.name, car.distance)
        }
    }

    init { validateName(name) }

    private fun validateName(name: String) {
        if (name.isBlank())
            throw IllegalArgumentException(ErrorMessage.CAR_NAME_EMPTY.message)

        if (name.length > NAME_MAX_LENGTH)
            throw IllegalArgumentException(ErrorMessage.CAR_NAME_LENGTH.message)
    }

    fun goForwardByPicker(numPicker: NumPicker) {
        val num = numPicker.pick()
        if (num >= 4) distance++
    }
}