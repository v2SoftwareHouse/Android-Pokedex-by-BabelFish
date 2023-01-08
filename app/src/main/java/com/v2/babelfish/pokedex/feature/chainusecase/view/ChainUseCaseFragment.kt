package com.v2.babelfish.pokedex.feature.chainusecase.view

import android.view.View
import com.v2.babelfish.pokedex.R
import com.v2.babelfish.pokedex.feature.chainusecase.gateway.ChainUseCaseController
import com.v2.babelfish.ui.BaseFragment
import com.v2.babelfish.pokedex.feature.chainusecase.view.ChainUseCaseViewInjector.Companion.self as injector

class ChainUseCaseFragment : BaseFragment<ChainUseCaseController>() {
    companion object {
        fun newInstance() = ChainUseCaseFragment()

        const val landingChannel = "landingChannel"
    }

    override fun channelName(): String = landingChannel

    override fun getLayout(): Int = R.layout.fragment_main

    override fun setupViews(view: View) {

    }

    override fun onStart() {
        super.onStart()
        fetch()
    }

    override fun handleSuccess(value: Any?) {
        injector.log.doLog(value.toString())
    }

    override fun setupController(): ChainUseCaseController {
        return injector.controllerFactory.create(this)
    }

    private fun fetch() {
        controller.doFetch(landingChannel)
    }
}