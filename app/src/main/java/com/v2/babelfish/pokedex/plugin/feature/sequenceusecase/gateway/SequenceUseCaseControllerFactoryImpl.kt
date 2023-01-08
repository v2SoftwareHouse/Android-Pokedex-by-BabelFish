package com.v2.babelfish.pokedex.plugin.feature.sequenceusecase.gateway

import androidx.lifecycle.ViewModelProvider
import com.v2.babelfish.mvvm.ControllerFactory
import com.v2.babelfish.pokedex.feature.sequenceusecase.gateway.SequenceUseCaseController
import com.v2.babelfish.pokedex.feature.sequenceusecase.view.SequenceUseCaseFragment

class SequenceUseCaseControllerFactoryImpl :
    ControllerFactory<SequenceUseCaseFragment, SequenceUseCaseController> {
    override fun create(context: SequenceUseCaseFragment): SequenceUseCaseController {
        return ViewModelProvider(context)[SequenceUseCaseViewModel::class.java]
    }
}