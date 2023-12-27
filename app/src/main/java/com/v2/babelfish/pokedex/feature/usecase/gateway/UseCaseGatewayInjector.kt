package com.v2.babelfish.pokedex.feature.usecase.gateway

import com.v2.babelfish.pokedex.feature.usecase.business.GETUseCase

interface UseCaseGatewayInjector {
    companion object {
        lateinit var self: UseCaseGatewayInjector
    }

    val getUseCase: GETUseCase
}