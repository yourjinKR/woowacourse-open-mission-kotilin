package lotto.controller

import camp.nextstep.edu.missionutils.Console
import lotto.domain.LottoGame
import lotto.domain.LottoNumbersPicker
import lotto.service.LottoService
import lotto.view.InputView
import lotto.view.OutputView

class LottoController(
    val inputView: InputView,
    val outputView: OutputView,
    val lottoService: LottoService
) {
    fun run() {
        val lottoGame = LottoGame(LottoNumbersPicker())

        repeatUntilSuccess {
            val purchaseRequest = inputView.purchaseAmount()
            val purchaseResponse = lottoService.purchaseLotto(purchaseRequest, lottoGame)
            outputView.purchaseResult(purchaseResponse)
        }

        repeatUntilSuccess {
            val winningRequest = inputView.winningLotto()
            val winningResponse = lottoService.getWinningResult(winningRequest, lottoGame)
            outputView.winningResult(winningResponse)
        }

        Console.close()
    }

    fun repeatUntilSuccess(action: () -> Unit) {
        while (true) {
            try {
                action()
                return
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun <T> repeatUntilSuccess(action: () -> T): T {
        while (true) {
            try {
                return action()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }
}