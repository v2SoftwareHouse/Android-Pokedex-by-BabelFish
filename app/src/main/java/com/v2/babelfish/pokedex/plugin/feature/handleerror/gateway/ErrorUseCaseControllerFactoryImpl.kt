package com.v2.babelfish.pokedex.plugin.feature.handleerror.gateway


import androidx.lifecycle.ViewModelProvider
import com.v2.babelfish.mvvm.ControllerFactory
import com.v2.babelfish.pokedex.feature.handleerror.gateway.ErrorUseCaseController
import com.v2.babelfish.pokedex.feature.handleerror.view.ErrorUseCaseFragment

class ErrorUseCaseControllerFactoryImpl :
    ControllerFactory<ErrorUseCaseFragment, ErrorUseCaseController> {
    override fun create(context: ErrorUseCaseFragment): ErrorUseCaseController {
        return ViewModelProvider(context)[ErrorUseCaseViewModel::class.java]
    }
}