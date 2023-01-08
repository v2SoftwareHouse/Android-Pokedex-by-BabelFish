package com.v2.babelfish.pokedex.plugin.feature.landing.gateway


import com.nhaarman.mockitokotlin2.spy
import com.v2.babelfish.mvvm.BaseViewModelTest
import com.v2.babelfish.pokedex.feature.landing.gateway.LandingGatewayInjector
import org.junit.After
import org.junit.Before

class LandingViewModelTest : BaseViewModelTest<LandingViewModel>() {
    @Before
    override fun setup() {
        super.setup()
    }

    @After
    override fun teardown() {
        super.teardown()
    }

    override fun setupViewModel() {
        LandingGatewayInjector.self = object : LandingGatewayInjector {}
        viewModel = spy(LandingViewModel())
    }
}