package lotto.controller.dto

data class PurchaseResponse(
    val amount: Int,
    val lottoList: List<LottoResponse>
)
