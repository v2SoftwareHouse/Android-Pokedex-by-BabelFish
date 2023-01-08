package com.v2.babelfish.pokedex.feature.handleerror.business

import com.v2.babelfish.pokedex.feature.handleerror.domain.Pokemon

interface ErrorUseCaseRepository {
    fun doFetch(name: String?): Pokemon?
}