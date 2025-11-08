package racingcar.domain

import racingcar.controller.dto.CarSnapShot

class RacingMapper {
    fun toDto(cars: List<Car>):List<CarSnapShot>  {
        return cars.map { car -> toDto(car) }
    }

    fun toDto(car: Car):CarSnapShot {
        return CarSnapShot(car.name, car.distance)
    }
}