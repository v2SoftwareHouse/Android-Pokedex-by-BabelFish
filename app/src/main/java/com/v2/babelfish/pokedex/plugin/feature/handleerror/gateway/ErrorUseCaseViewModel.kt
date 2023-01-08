package com.v2.babelfish.pokedex.plugin.feature.handleerror.gateway

import com.v2.babelfish.mvvm.BaseViewModel
import com.v2.babelfish.pokedex.feature.handleerror.business.ErrorUseCase
import com.v2.babelfish.pokedex.feature.handleerror.gateway.ErrorUseCaseController
import com.v2.babelfish.pokedex.feature.handleerror.gateway.ErrorUseCaseGatewayInjector.Companion.self as injector

open class ErrorUseCaseViewModel : BaseViewModel(), ErrorUseCaseController {
    private val doError by lazy { injectError() }

    private fun injectError(): ErrorUseCase {
        return injector.doError
    }

    override fun doFetch(channelName: String) {
        //null generate error on getPokemon api
        dispatchUseCase(null, doError) { postValue(channelName, it) }
    }
}