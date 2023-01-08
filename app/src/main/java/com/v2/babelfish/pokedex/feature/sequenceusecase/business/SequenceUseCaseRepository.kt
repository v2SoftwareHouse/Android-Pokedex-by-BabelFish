package com.v2.babelfish.pokedex.feature.sequenceusecase.business

import com.v2.babelfish.pokedex.feature.sequenceusecase.domain.Pokemon

interface SequenceUseCaseRepository {
    fun getBulbasaur(): Pokemon?
    fun getIvysaur(): Pokemon?
    fun getVenusaur(): Pokemon?
}