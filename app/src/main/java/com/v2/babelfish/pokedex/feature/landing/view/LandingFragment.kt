package com.v2.babelfish.pokedex.feature.landing.view

import android.view.View
import androidx.appcompat.widget.AppCompatButton
import com.v2.babelfish.ui.BaseFragment
import com.v2.babelfish.pokedex.R
import com.v2.babelfish.pokedex.feature.chainusecase.view.ChainUseCaseFragment
import com.v2.babelfish.pokedex.feature.handleerror.view.ErrorUseCaseFragment
import com.v2.babelfish.pokedex.feature.landing.gateway.LandingController
import com.v2.babelfish.pokedex.feature.sequenceusecase.view.SequenceUseCaseFragment
import com.v2.babelfish.pokedex.feature.usecase.view.UseCaseFragment
import com.v2.babelfish.pokedex.feature.landing.view.LandingViewInjector.Companion.self as injector

class LandingFragment : BaseFragment<LandingController>(), View.OnClickListener {
    companion object {
        fun newInstance() = LandingFragment()

        const val landingChannel = "landingChannel"
    }

    override fun channelName(): String = landingChannel

    override fun getLayout(): Int = R.layout.fragment_main

    override fun setupViews(view: View) {
        view.findViewById<AppCompatButton>(R.id.open_unit_usecase).setOnClickListener(this)
        view.findViewById<AppCompatButton>(R.id.open_chain_usecase).setOnClickListener(this)
        view.findViewById<AppCompatButton>(R.id.open_sequence_usecase).setOnClickListener(this)
        view.findViewById<AppCompatButton>(R.id.open_error_usecase).setOnClickListener(this)
    }

    override fun handleError(error: Throwable?) {
        injector.log.doLog(error.toString())
    }

    override fun setupController(): LandingController {
        return injector.controllerFactory.create(this)
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.open_unit_usecase -> openUseCaseFragment()
            R.id.open_chain_usecase -> openChainUseCaseFragment()
            R.id.open_sequence_usecase -> openSequenceUseCaseFragment()
            R.id.open_error_usecase -> openErrorUseCaseFragment()
            R.id.open_guard_usecase -> openGuardUseCaseFragment()
        }
    }

    private fun openUseCaseFragment() {
        activity?.supportFragmentManager?.beginTransaction()
            ?.replace(R.id.container, UseCaseFragment.newInstance())?.commitNow()
    }

    private fun openChainUseCaseFragment() {
        activity?.supportFragmentManager?.beginTransaction()
            ?.replace(R.id.container, ChainUseCaseFragment.newInstance())?.commitNow()
    }

    private fun openSequenceUseCaseFragment() {
        activity?.supportFragmentManager?.beginTransaction()
            ?.replace(R.id.container, SequenceUseCaseFragment.newInstance())?.commitNow()
    }

    private fun openErrorUseCaseFragment() {
        activity?.supportFragmentManager?.beginTransaction()
            ?.replace(R.id.container, ErrorUseCaseFragment.newInstance())?.commitNow()
    }

    private fun openGuardUseCaseFragment() {

    }
}