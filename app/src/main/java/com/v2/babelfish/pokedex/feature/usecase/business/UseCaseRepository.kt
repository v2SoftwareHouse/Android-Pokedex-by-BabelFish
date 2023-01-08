package com.v2.babelfish.pokedex.feature.usecase.business

import com.v2.babelfish.pokedex.feature.usecase.domain.Pokemon

interface UseCaseRepository {
    fun doFetch(name: String?): Pokemon?
}