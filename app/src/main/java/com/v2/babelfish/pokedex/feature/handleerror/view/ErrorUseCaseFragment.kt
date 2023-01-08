package com.v2.babelfish.pokedex.feature.handleerror.view

import android.view.View
import com.v2.babelfish.pokedex.R
import com.v2.babelfish.pokedex.feature.handleerror.gateway.ErrorUseCaseController
import com.v2.babelfish.ui.BaseFragment
import com.v2.babelfish.pokedex.feature.handleerror.view.ErrorUseCaseViewInjector.Companion.self as injector

class ErrorUseCaseFragment : BaseFragment<ErrorUseCaseController>() {
    companion object {
        fun newInstance() = ErrorUseCaseFragment()

        const val errorUseCaseChannel = "errorUseCaseChannel"
    }

    override fun channelName(): String = errorUseCaseChannel

    override fun getLayout(): Int = R.layout.fragment_main

    override fun setupViews(view: View) {

    }

    override fun onStart() {
        super.onStart()
        fetch()
    }

    override fun handleError(error: Throwable?) {
        injector.log.doLog(error.toString())
    }

    override fun setupController(): ErrorUseCaseController {
        return injector.controllerFactory.create(this)
    }

    private fun fetch() {
        controller.doFetch(errorUseCaseChannel)
    }
}