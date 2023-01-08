package com.v2.babelfish.pokedex.plugin.feature.handleerror

import com.v2.babelfish.business.exception.AuthenticationException
import com.v2.babelfish.business.exception.HttpException
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.spy
import com.nhaarman.mockitokotlin2.whenever
import com.v2.babelfish.pokedex.DataFactory
import com.v2.babelfish.pokedex.feature.handleerror.domain.Pokemon
import com.v2.babelfish.pokedex.plugin.feature.LoggedInRepositoryTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test

class ErrorUseCaseRepositoryImplTest : LoggedInRepositoryTest<ErrorUseCaseRepositoryImpl>() {
    private val pokemon = DataFactory.mockErrorUseCaseDataPokemon()

    override fun setupRepository(httpUrl: String) {
        repository = spy(ErrorUseCaseRepositoryImpl(httpUrl))
    }

    @Test
    fun `when doFetch assert returns 200, should return Pokemon object`() {
        enqueueEmptyResponse(200)
        stubDoFetch(pokemon)
        val name = DataFactory.randomUuid()
        val response = repository.doFetch(name)

        assertNotNull(response)
        assertEquals(response, pokemon)
    }

    @Test(expected = HttpException::class)
    fun `when doFetch assert returns 400, then throw HttpException`() {
        enqueueEmptyResponse(400)
        stubDoFetch(pokemon)
        val name = DataFactory.randomUuid()
        repository.doFetch(name)
    }

    @Test(expected = AuthenticationException::class)
    fun `when doFetch assert returns 401, then throw HttpException`() {
        enqueueEmptyResponse(401)
        stubDoFetch(pokemon)
        val name = DataFactory.randomUuid()
        repository.doFetch(name)
    }

    @Test(expected = HttpException::class)
    fun `when doFetch assert returns 500, then throw HttpException`() {
        enqueueEmptyResponse(500)
        stubDoFetch(pokemon)
        val name = DataFactory.randomUuid()
        repository.doFetch(name)
    }

    private fun stubDoFetch(pokemon: Pokemon) =
        whenever(repository.doFetch(any()))
            .thenReturn(pokemon)
}