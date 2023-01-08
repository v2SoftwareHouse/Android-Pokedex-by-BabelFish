package com.v2.babelfish.pokedex.plugin.feature.sequenceusecase.gateway

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.spy
import com.nhaarman.mockitokotlin2.whenever
import com.v2.babelfish.mvvm.BaseViewModelTest
import com.v2.babelfish.pokedex.DataFactory
import com.v2.babelfish.pokedex.feature.sequenceusecase.business.GETBulbasaurUseCase
import com.v2.babelfish.pokedex.feature.sequenceusecase.business.GETIvysaurUseCase
import com.v2.babelfish.pokedex.feature.sequenceusecase.business.GETVenusaurUseCase
import com.v2.babelfish.pokedex.feature.sequenceusecase.business.SequenceUseCaseRepository
import com.v2.babelfish.pokedex.feature.sequenceusecase.domain.Pokemon
import com.v2.babelfish.pokedex.feature.sequenceusecase.gateway.SequenceUseCaseGatewayInjector
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test

class SequenceUseCaseViewModelTest : BaseViewModelTest<SequenceUseCaseViewModel>() {
    private lateinit var repository: SequenceUseCaseRepository

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
        SequenceUseCaseGatewayInjector.self = object : SequenceUseCaseGatewayInjector {
            override val getBulbasaur: GETBulbasaurUseCase
                get() = GETBulbasaurUseCase(repository)
            override val getIvysaur: GETIvysaurUseCase
                get() = GETIvysaurUseCase(repository)
            override val getVenusaur: GETVenusaurUseCase
                get() = GETVenusaurUseCase(repository)
        }
        viewModel = spy(SequenceUseCaseViewModel())
    }

    private fun doGet() {
        runBlocking { viewModel?.doFetch(DataFactory.randomUuid()) }
    }

    private fun arrangeFetch(): Pokemon {
        val result = mock<Pokemon>()
        whenever(repository.getBulbasaur()).thenReturn(result)
        whenever(repository.getIvysaur()).thenReturn(result)
        whenever(repository.getVenusaur()).thenReturn(result)

        return result
    }
}