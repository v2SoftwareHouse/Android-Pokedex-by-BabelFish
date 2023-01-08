package com.v2.babelfish.pokedex.feature.usecase.view

import android.view.View
import com.v2.babelfish.pokedex.R
import com.v2.babelfish.pokedex.feature.usecase.domain.Pokemon
import com.v2.babelfish.pokedex.feature.usecase.gateway.UseCaseController
import com.v2.babelfish.ui.BaseFragment
import com.v2.babelfish.pokedex.feature.usecase.view.UseCaseViewInjector.Companion.self as injector

class UseCaseFragment : BaseFragment<UseCaseController>() {
    companion object {
        fun newInstance() = UseCaseFragment()

        const val useCaseChannel = "useCaseChannel"
    }

    override fun channelName(): String = useCaseChannel

    override fun getLayout(): Int = R.layout.fragment_main

    override fun setupViews(view: View) {

    }

    override fun onStart() {
        super.onStart()
        fetch()
    }

    override fun handleSuccess(value: Any?) {
        when (value) {
            is Pokemon -> {
                injector.log.doLog(value.toString())
            }
        }
    }

    override fun setupController(): UseCaseController {
        return injector.controllerFactory.create(this)
    }

    private fun fetch() {
        controller.doFetch(useCaseChannel)
    }
}