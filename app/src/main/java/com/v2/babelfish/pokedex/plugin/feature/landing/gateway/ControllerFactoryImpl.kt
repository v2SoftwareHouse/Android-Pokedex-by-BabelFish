package com.v2.babelfish.pokedex.plugin.feature.landing.gateway

import androidx.lifecycle.ViewModelProvider
import com.v2.babelfish.mvvm.ControllerFactory
import com.v2.babelfish.pokedex.feature.landing.gateway.LandingController
import com.v2.babelfish.pokedex.feature.landing.view.LandingFragment

class ControllerFactoryImpl : ControllerFactory<LandingFragment, LandingController> {
    override fun create(context: LandingFragment): LandingController {
        return ViewModelProvider(context)[LandingViewModel::class.java]
    }
}