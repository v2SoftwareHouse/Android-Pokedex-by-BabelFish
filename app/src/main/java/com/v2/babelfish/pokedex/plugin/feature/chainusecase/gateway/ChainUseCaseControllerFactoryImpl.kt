package com.v2.babelfish.pokedex.plugin.feature.chainusecase.gateway

import androidx.lifecycle.ViewModelProvider
import com.v2.babelfish.mvvm.ControllerFactory
import com.v2.babelfish.pokedex.feature.chainusecase.gateway.ChainUseCaseController
import com.v2.babelfish.pokedex.feature.chainusecase.view.ChainUseCaseFragment

class ChainUseCaseControllerFactoryImpl : ControllerFactory<ChainUseCaseFragment, ChainUseCaseController> {
    override fun create(context: ChainUseCaseFragment): ChainUseCaseController {
        return ViewModelProvider(context)[ChainUseCaseViewModel::class.java]
    }
}