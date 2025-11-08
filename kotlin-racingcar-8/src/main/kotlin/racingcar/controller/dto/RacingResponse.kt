package racingcar.controller.dto


data class RacingResponse(
    val racingSnapShots: List<RacingSnapShot>,
    val winners: List<String>
)
