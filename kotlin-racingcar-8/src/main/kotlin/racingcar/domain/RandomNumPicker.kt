package racingcar.domain

import kotlin.random.Random

class RandomNumPicker(): NumPicker {
    companion object {
        const val MIN_NUM = 0
        const val MAX_NUM = 9
    }

    override fun pick(): Int {
        return Random.nextInt(MIN_NUM, MAX_NUM)
    }
}