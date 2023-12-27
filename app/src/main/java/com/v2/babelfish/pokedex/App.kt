package com.v2.babelfish.pokedex

import android.app.Application
import com.v2.babelfish.mvvm.ControllerFactory
import com.v2.babelfish.pokedex.common.LogMe
import com.v2.babelfish.pokedex.feature.chainusecase.business.ChainUseCaseRepository
import com.v2.babelfish.pokedex.feature.chainusecase.business.GETBulbasaurUseCase
import com.v2.babelfish.pokedex.feature.chainusecase.business.GETVenusaurUseCase
import com.v2.babelfish.pokedex.feature.chainusecase.gateway.ChainUseCaseController
import com.v2.babelfish.pokedex.feature.chainusecase.gateway.ChainUseCaseGatewayInjector
import com.v2.babelfish.pokedex.feature.chainusecase.view.ChainUseCaseFragment
import com.v2.babelfish.pokedex.feature.chainusecase.view.ChainUseCaseViewInjector
import com.v2.babelfish.pokedex.feature.handleerror.business.ErrorUseCase
import com.v2.babelfish.pokedex.feature.handleerror.business.ErrorUseCaseRepository
import com.v2.babelfish.pokedex.feature.handleerror.gateway.ErrorUseCaseController
import com.v2.babelfish.pokedex.feature.handleerror.gateway.ErrorUseCaseGatewayInjector
import com.v2.babelfish.pokedex.feature.handleerror.view.ErrorUseCaseFragment
import com.v2.babelfish.pokedex.feature.handleerror.view.ErrorUseCaseViewInjector
import com.v2.babelfish.pokedex.feature.landing.gateway.LandingController
import com.v2.babelfish.pokedex.feature.landing.gateway.LandingGatewayInjector
import com.v2.babelfish.pokedex.feature.landing.view.LandingFragment
import com.v2.babelfish.pokedex.feature.landing.view.LandingViewInjector
import com.v2.babelfish.pokedex.feature.sequenceusecase.business.GETIvysaurUseCase
import com.v2.babelfish.pokedex.feature.sequenceusecase.business.SequenceUseCaseRepository
import com.v2.babelfish.pokedex.feature.sequenceusecase.gateway.SequenceUseCaseController
import com.v2.babelfish.pokedex.feature.sequenceusecase.gateway.SequenceUseCaseGatewayInjector
import com.v2.babelfish.pokedex.feature.sequenceusecase.view.SequenceUseCaseFragment
import com.v2.babelfish.pokedex.feature.sequenceusecase.view.SequenceUseCaseViewInjector
import com.v2.babelfish.pokedex.feature.usecase.business.UseCaseRepository
import com.v2.babelfish.pokedex.feature.usecase.gateway.UseCaseController
import com.v2.babelfish.pokedex.feature.usecase.gateway.UseCaseGatewayInjector
import com.v2.babelfish.pokedex.feature.usecase.view.UseCaseFragment
import com.v2.babelfish.pokedex.feature.usecase.view.UseCaseViewInjector
import com.v2.babelfish.pokedex.plugin.feature.chainusecase.ChainUseCaseRepositoryImpl
import com.v2.babelfish.pokedex.plugin.feature.chainusecase.gateway.ChainUseCaseControllerFactoryImpl
import com.v2.babelfish.pokedex.plugin.feature.handleerror.ErrorUseCaseRepositoryImpl
import com.v2.babelfish.pokedex.plugin.feature.handleerror.gateway.ErrorUseCaseControllerFactoryImpl
import com.v2.babelfish.pokedex.plugin.feature.landing.gateway.ControllerFactoryImpl
import com.v2.babelfish.pokedex.plugin.feature.sequenceusecase.SequenceUseCaseRepositoryImpl
import com.v2.babelfish.pokedex.plugin.feature.sequenceusecase.gateway.SequenceUseCaseControllerFactoryImpl
import com.v2.babelfish.pokedex.plugin.feature.usecase.UseCaseRepositoryImpl
import com.v2.babelfish.pokedex.plugin.feature.usecase.gateway.UseCaseControllerFactoryImpl

class App : Application() {
    private val baseApiUrl = "https://pokeapi.co/api/v2/"

    override fun onCreate() {
        super.onCreate()
        doLandingGatewayInjector()
        doChainUseCaseGatewayInjector()
        doSequenceUseCaseGatewayInjector()
        doUseCaseGatewayInjector()
        doErrorUseCaseGatewayInjector()
    }

    private fun doChainUseCaseGatewayInjector() {
        ChainUseCaseGatewayInjector.self = object : ChainUseCaseGatewayInjector {
            override val getBulbasaur: GETBulbasaurUseCase
                get() = GETBulbasaurUseCase(injectaCacheRepository())
            override val getVenusaur: GETVenusaurUseCase
                get() = GETVenusaurUseCase(injectaCacheRepository())
        }

        ChainUseCaseViewInjector.self = object : ChainUseCaseViewInjector {
            override val controllerFactory: ControllerFactory<ChainUseCaseFragment, ChainUseCaseController>
                get() = ChainUseCaseControllerFactoryImpl()
            override val log: LogMe get() = LogMe
        }
    }

    private fun injectaCacheRepository(): ChainUseCaseRepository {
        return ChainUseCaseRepositoryImpl(baseApiUrl)
    }

    private fun doSequenceUseCaseGatewayInjector() {
        SequenceUseCaseGatewayInjector.self = object : SequenceUseCaseGatewayInjector {
            override val getBulbasaur: com.v2.babelfish.pokedex.feature.sequenceusecase.business.GETBulbasaurUseCase
                get() = com.v2.babelfish.pokedex.feature.sequenceusecase.business.GETBulbasaurUseCase(
                    injectSequenceRepository()
                )

            override val getIvysaur: GETIvysaurUseCase
                get() = GETIvysaurUseCase(injectSequenceRepository())
            override val getVenusaur: com.v2.babelfish.pokedex.feature.sequenceusecase.business.GETVenusaurUseCase
                get() = com.v2.babelfish.pokedex.feature.sequenceusecase.business.GETVenusaurUseCase(
                    injectSequenceRepository()
                )
        }

        SequenceUseCaseViewInjector.self = object : SequenceUseCaseViewInjector {
            override val controllerFactory: ControllerFactory<SequenceUseCaseFragment, SequenceUseCaseController>
                get() = SequenceUseCaseControllerFactoryImpl()
            override val log: LogMe get() = LogMe
        }
    }

    private fun injectSequenceRepository(): SequenceUseCaseRepository {
        return SequenceUseCaseRepositoryImpl(baseApiUrl)
    }

    private fun doUseCaseGatewayInjector() {
        UseCaseGatewayInjector.self = object : UseCaseGatewayInjector {
            override val getUseCase: com.v2.babelfish.pokedex.feature.usecase.business.GETUseCase
                get() = com.v2.babelfish.pokedex.feature.usecase.business.GETUseCase(
                    injectUseCaseRepository()
                )
        }

        UseCaseViewInjector.self = object : UseCaseViewInjector {
            override val controllerFactory: ControllerFactory<UseCaseFragment, UseCaseController>
                get() = UseCaseControllerFactoryImpl()
            override val log: LogMe get() = LogMe
        }
    }

    private fun injectUseCaseRepository(): UseCaseRepository {
        return UseCaseRepositoryImpl(baseApiUrl)
    }

    private fun doErrorUseCaseGatewayInjector() {
        ErrorUseCaseGatewayInjector.self = object : ErrorUseCaseGatewayInjector {
            override val doError: ErrorUseCase
                get() = ErrorUseCase(injectErrorUseCaseRepository())
        }

        ErrorUseCaseViewInjector.self = object : ErrorUseCaseViewInjector {
            override val controllerFactory: ControllerFactory<ErrorUseCaseFragment, ErrorUseCaseController>
                get() = ErrorUseCaseControllerFactoryImpl()
            override val log: LogMe get() = LogMe
        }
    }

    private fun injectErrorUseCaseRepository(): ErrorUseCaseRepository {
        return ErrorUseCaseRepositoryImpl(baseApiUrl)
    }

    private fun doLandingGatewayInjector() {
        LandingGatewayInjector.self = object : LandingGatewayInjector {

        }

        LandingViewInjector.self = object : LandingViewInjector {
            override val controllerFactory: ControllerFactory<LandingFragment, LandingController>
                get() = ControllerFactoryImpl()
            override val log: LogMe get() = LogMe
        }
    }
}