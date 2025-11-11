package lotto.service

import lotto.controller.dto.PurchaseRequest
import lotto.controller.dto.PurchaseResponse
import lotto.controller.dto.WinningRequest
import lotto.controller.dto.WinningResponse
import lotto.domain.LottoGame
import lotto.domain.WinningLotto
import lotto.mapper.LottoMapper
import lotto.repository.LottoRepository

class LottoService(
    private val lottoMapper: LottoMapper,
    private val lottoRepository: LottoRepository
) {

    fun purchaseLotto(request: PurchaseRequest, lottoGame: LottoGame): PurchaseResponse {
        val purchaseAmount = request.purchaseAmount
        val ticket = lottoGame.purchaseLottoTickets(purchaseAmount)
        val lottoList = List(ticket) { lottoGame.pickLottoByPickRule() }

        lottoRepository.saveAll(lottoList)

        return lottoMapper.toDto(lottoList)
    }

    fun getWinningResult(request: WinningRequest, lottoGame: LottoGame): WinningResponse {
        val winningLotto = WinningLotto(
            numbers = request.winningNumbers,
            bonusNumber = request.bonusNumber
        )

        val lottoList = lottoRepository.findAll()

        val mappedMatchingResult =  lottoGame.getMappedMatchingResult(winningLotto, lottoList)
        val yield = lottoGame.getYield(lottoList, mappedMatchingResult)

        return lottoMapper.toDto(mappedMatchingResult, yield)
    }
}