package com.v2.babelfish.pokedex.feature.handleerror.view

import com.v2.babelfish.mvvm.ControllerFactory
import com.v2.babelfish.pokedex.common.LogMe
import com.v2.babelfish.pokedex.feature.handleerror.gateway.ErrorUseCaseController

interface ErrorUseCaseViewInjector {
    companion object {
        lateinit var self: ErrorUseCaseViewInjector
    }

    val controllerFactory: ControllerFactory<ErrorUseCaseFragment, ErrorUseCaseController>
    val log: LogMe
}