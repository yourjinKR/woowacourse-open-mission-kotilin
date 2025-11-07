package racingcar.domain

class Car(val name: String) {
    companion object {
        const val NAME_MAX_LENGTH = 5
    }

    var distance = 0
        private set

    init { validateName(name) }

    private fun validateName(name: String) {
        if (name.isBlank())
            throw IllegalArgumentException("")

        if (name.length > NAME_MAX_LENGTH)
            throw IllegalArgumentException("")
    }

    fun goForwardByPicker(numPicker: NumPicker) {
        val num = numPicker.pick()
        if (num >= 4) distance++
    }
}