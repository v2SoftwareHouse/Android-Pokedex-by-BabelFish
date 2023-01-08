package com.v2.babelfish.pokedex.feature.chainusecase.view

import com.v2.babelfish.mvvm.ControllerFactory
import com.v2.babelfish.pokedex.common.LogMe
import com.v2.babelfish.pokedex.feature.chainusecase.gateway.ChainUseCaseController

interface ChainUseCaseViewInjector {
    companion object {
        lateinit var self: ChainUseCaseViewInjector
    }

    val controllerFactory: ControllerFactory<ChainUseCaseFragment, ChainUseCaseController>
    val log: LogMe
}