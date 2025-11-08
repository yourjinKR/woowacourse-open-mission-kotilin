package racingcar.domain

class CarFactory {
    companion object {
        fun createNamesFrom(names: List<String>): List<Car> {
            return names.map { names -> Car(names) }
        }
    }
}