package lotto

import lotto.controller.LottoController
import lotto.mapper.LottoMapper
import lotto.repository.LottoRepository
import lotto.service.LottoService
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    // TODO: 반올림, 테스트코드, 줄바꿈 점검 필요
    val lottoController = LottoController(
        InputView(),
        OutputView(),
        LottoService(
            LottoMapper(),
            LottoRepository()
        )
    )
    lottoController.run()
}
