package com.v2.babelfish.pokedex.feature.chainusecase.business

import com.v2.babelfish.pokedex.feature.chainusecase.domain.Pokemon


interface ChainUseCaseRepository {
    fun getBulbasaur(): Pokemon?
    fun getIvysaur(): Pokemon?
}