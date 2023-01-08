package com.v2.babelfish.pokedex.plugin.feature.sequenceusecase.gateway

import com.v2.babelfish.business.interactor.SequenceUseCase
import com.v2.babelfish.mvvm.BaseViewModel
import com.v2.babelfish.pokedex.feature.sequenceusecase.business.GETBulbasaurUseCase
import com.v2.babelfish.pokedex.feature.sequenceusecase.business.GETIvysaurUseCase
import com.v2.babelfish.pokedex.feature.sequenceusecase.business.GETVenusaurUseCase
import com.v2.babelfish.pokedex.feature.sequenceusecase.gateway.SequenceUseCaseController
import com.v2.babelfish.pokedex.feature.sequenceusecase.gateway.SequenceUseCaseGatewayInjector.Companion.self as injector

open class SequenceUseCaseViewModel : BaseViewModel(), SequenceUseCaseController {
    private val getBulbasaur by lazy { injectBulbasaurUseCase() }
    private val getVenusaur by lazy { injectVenusaurUseCase() }
    private val getIvysaur by lazy { injectIvysaurUseCase() }

    private fun injectBulbasaurUseCase(): GETBulbasaurUseCase {
        return injector.getBulbasaur
    }

    private fun injectVenusaurUseCase(): GETVenusaurUseCase {
        return injector.getVenusaur
    }

    private fun injectIvysaurUseCase(): GETIvysaurUseCase {
        return injector.getIvysaur
    }

    override fun doFetch(channelName: String) {
        val sequence = SequenceUseCase.builder()
            .add(getBulbasaur)
            .add(getIvysaur)
            .add(getVenusaur)
            .build()

        dispatchUseCase(null, sequence) {
            postValue(channelName, it)
        }
    }
}