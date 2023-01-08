package com.v2.babelfish.pokedex.feature.sequenceusecase.view

import com.v2.babelfish.mvvm.ControllerFactory
import com.v2.babelfish.pokedex.common.LogMe
import com.v2.babelfish.pokedex.feature.sequenceusecase.gateway.SequenceUseCaseController

interface SequenceUseCaseViewInjector {
    companion object {
        lateinit var self: SequenceUseCaseViewInjector
    }

    val controllerFactory: ControllerFactory<SequenceUseCaseFragment, SequenceUseCaseController>
    val log: LogMe
}