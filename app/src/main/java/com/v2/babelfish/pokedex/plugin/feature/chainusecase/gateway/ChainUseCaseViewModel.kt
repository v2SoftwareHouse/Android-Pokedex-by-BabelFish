package com.v2.babelfish.pokedex.plugin.feature.chainusecase.gateway

import com.v2.babelfish.business.interactor.ChainedUseCase
import com.v2.babelfish.mvvm.BaseViewModel
import com.v2.babelfish.pokedex.feature.chainusecase.business.GETBulbasaurUseCase
import com.v2.babelfish.pokedex.feature.chainusecase.business.GETVenusaurUseCase
import com.v2.babelfish.pokedex.feature.chainusecase.gateway.ChainUseCaseController
import com.v2.babelfish.pokedex.feature.chainusecase.gateway.ChainUseCaseGatewayInjector.Companion.self as injector

open class ChainUseCaseViewModel : BaseViewModel(), ChainUseCaseController {
    private val getBulbasaur by lazy { injectBulbasaurUseCase() }
    private val getVenusaur by lazy { injectVenusaurUseCase() }

    private fun injectBulbasaurUseCase(): GETBulbasaurUseCase {
        return injector.getBulbasaur
    }

    private fun injectVenusaurUseCase(): GETVenusaurUseCase {
        return injector.getVenusaur
    }

    override fun doFetch(channelName: String) {
        val chainedUseCase = ChainedUseCase(getBulbasaur, getVenusaur)
        dispatchUseCase(null, chainedUseCase) { postValue(channelName, it) }
    }
}