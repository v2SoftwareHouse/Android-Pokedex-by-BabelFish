package com.v2.babelfish.pokedex.plugin.feature.usecase.gateway

import com.v2.babelfish.mvvm.BaseViewModel
import com.v2.babelfish.pokedex.feature.usecase.business.GETUseCase
import com.v2.babelfish.pokedex.feature.usecase.gateway.UseCaseController
import com.v2.babelfish.pokedex.feature.usecase.gateway.UseCaseGatewayInjector.Companion.self as injector

open class UseCaseViewModel : BaseViewModel(), UseCaseController {
    private val getUseCase by lazy { injectUseCase() }

    private fun injectUseCase(): GETUseCase {
        return injector.getUseCase
    }

    override fun doFetch(channelName: String) {
        dispatchUseCase(POKEMON_NAME, getUseCase) { postValue(channelName, it) }
    }

    companion object {
        private const val POKEMON_NAME = "bulbasaur"
    }
}