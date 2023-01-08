package com.v2.babelfish.pokedex.feature.handleerror.gateway

import com.v2.babelfish.pokedex.feature.handleerror.business.ErrorUseCase

interface ErrorUseCaseGatewayInjector {
    companion object {
        lateinit var self: ErrorUseCaseGatewayInjector
    }

    val doError: ErrorUseCase
}