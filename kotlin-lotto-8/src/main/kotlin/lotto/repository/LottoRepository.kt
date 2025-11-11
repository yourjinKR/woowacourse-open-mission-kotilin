package lotto.repository

import lotto.domain.Lotto

class LottoRepository {
    private var lottoList = mutableListOf<Lotto>()

    fun save(lotto: Lotto) {
        lottoList.add(lotto)
    }

    fun saveAll(lottoList : List<Lotto>) {
        this.lottoList.addAll(lottoList)
    }

    fun findAll(): List<Lotto> {
        return lottoList.map { lotto -> Lotto(lotto.numbers) }
    }
}