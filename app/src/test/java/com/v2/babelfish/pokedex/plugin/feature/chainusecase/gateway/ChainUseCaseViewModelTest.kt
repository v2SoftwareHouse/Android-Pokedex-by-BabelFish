package com.v2.babelfish.pokedex.plugin.feature.chainusecase.gateway

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.spy
import com.nhaarman.mockitokotlin2.whenever
import com.v2.babelfish.mvvm.BaseViewModelTest
import com.v2.babelfish.pokedex.DataFactory
import com.v2.babelfish.pokedex.feature.chainusecase.business.ChainUseCaseRepository
import com.v2.babelfish.pokedex.feature.chainusecase.business.GETBulbasaurUseCase
import com.v2.babelfish.pokedex.feature.chainusecase.business.GETVenusaurUseCase
import com.v2.babelfish.pokedex.feature.chainusecase.domain.Pokemon
import com.v2.babelfish.pokedex.feature.chainusecase.gateway.ChainUseCaseGatewayInjector
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test

class ChainUseCaseViewModelTest : BaseViewModelTest<ChainUseCaseViewModel>() {
    private lateinit var repository: ChainUseCaseRepository

    @Before
    override fun setup() {
        super.setup()
    }

    @After
    override fun teardown() {
        super.teardown()
    }

    @Test
    fun `when fetch succeeds, assert callbacks`() {
        val result = arrangeFetch()
        doGet()
        assertViewStateSuccess(result)
    }

    @Test
    fun `when getBulbasaur throws exception, assert callbacks`() {
        val exception = RuntimeException()

        whenever(repository.getBulbasaur()).thenThrow(exception)
        doGet()
        assertViewStateError(exception)
    }

    override fun setupViewModel() {
        repository = mock()
        ChainUseCaseGatewayInjector.self = object : ChainUseCaseGatewayInjector {
            override val getBulbasaur: GETBulbasaurUseCase
                get() = GETBulbasaurUseCase(repository)
            override val getVenusaur: GETVenusaurUseCase
                get() = GETVenusaurUseCase(repository)
        }
        viewModel = spy(ChainUseCaseViewModel())
    }

    private fun doGet() {
        runBlocking { viewModel?.doFetch(DataFactory.randomUuid()) }
    }

    private fun arrangeFetch(): Pokemon {
        val result = mock<Pokemon>()
        whenever(repository.getBulbasaur()).thenReturn(result)
        whenever(repository.getIvysaur()).thenReturn(result)

        return result
    }
}