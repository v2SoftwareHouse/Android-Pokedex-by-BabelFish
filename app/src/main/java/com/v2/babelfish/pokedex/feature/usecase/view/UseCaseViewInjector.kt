package com.v2.babelfish.pokedex.feature.usecase.view

import com.v2.babelfish.mvvm.ControllerFactory
import com.v2.babelfish.pokedex.common.LogMe
import com.v2.babelfish.pokedex.feature.usecase.gateway.UseCaseController

interface UseCaseViewInjector {
    companion object {
        lateinit var self: UseCaseViewInjector
    }

    val controllerFactory: ControllerFactory<UseCaseFragment, UseCaseController>
    val log: LogMe
}