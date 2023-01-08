package com.v2.babelfish.pokedex.feature.landing.view

import com.v2.babelfish.mvvm.ControllerFactory
import com.v2.babelfish.pokedex.common.LogMe
import com.v2.babelfish.pokedex.feature.landing.gateway.LandingController

interface LandingViewInjector {
    companion object {
        lateinit var self: LandingViewInjector
    }

    val controllerFactory: ControllerFactory<LandingFragment, LandingController>
    val log: LogMe
}