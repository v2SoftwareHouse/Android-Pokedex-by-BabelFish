package com.v2.babelfish.pokedex.plugin.feature.usecase.gateway

import androidx.lifecycle.ViewModelProvider
import com.v2.babelfish.mvvm.ControllerFactory
import com.v2.babelfish.pokedex.feature.usecase.gateway.UseCaseController
import com.v2.babelfish.pokedex.feature.usecase.view.UseCaseFragment

class UseCaseControllerFactoryImpl : ControllerFactory<UseCaseFragment, UseCaseController> {
    override fun create(context: UseCaseFragment): UseCaseController {
        return ViewModelProvider(context)[UseCaseViewModel::class.java]
    }
}