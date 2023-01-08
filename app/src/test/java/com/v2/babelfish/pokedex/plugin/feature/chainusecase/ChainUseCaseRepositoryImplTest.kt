package com.v2.babelfish.pokedex.plugin.feature.chainusecase

import com.v2.babelfish.business.exception.AuthenticationException
import com.v2.babelfish.business.exception.HttpException
import com.nhaarman.mockitokotlin2.spy
import com.nhaarman.mockitokotlin2.whenever
import com.v2.babelfish.pokedex.DataFactory
import com.v2.babelfish.pokedex.feature.chainusecase.domain.Pokemon
import com.v2.babelfish.pokedex.plugin.feature.LoggedInRepositoryTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test

class ChainUseCaseRepositoryImplTest : LoggedInRepositoryTest<ChainUseCaseRepositoryImpl>() {
    private val bulbasaur = DataFactory.mockBulbasaurChainUseCaseData()
    private val ivysaur = DataFactory.mockIvysaurChainUseCaseData()

    override fun setupRepository(httpUrl: String) {
        repository = spy(ChainUseCaseRepositoryImpl(httpUrl))
    }

    @Test
    fun `when getBulbasaur assert returns 200, should return Pokemon object`() {
        enqueueEmptyResponse(200)
        stubGetBulbasaur(bulbasaur)

        val response = repository.getBulbasaur()

        assertNotNull(response)
        assertEquals(response, bulbasaur)
    }

    @Test(expected = HttpException::class)
    fun `when getBulbasaur assert returns 400, then throw HttpException`() {
        enqueueEmptyResponse(400)
        stubGetBulbasaur(bulbasaur)
        repository.getBulbasaur()
    }

    @Test(expected = AuthenticationException::class)
    fun `when getBulbasaur assert returns 401, then throw HttpException`() {
        enqueueEmptyResponse(401)
        stubGetBulbasaur(bulbasaur)
        repository.getBulbasaur()
    }

    @Test(expected = HttpException::class)
    fun `when getBulbasaur assert returns 500, then throw HttpException`() {
        enqueueEmptyResponse(500)
        stubGetBulbasaur(bulbasaur)
        repository.getBulbasaur()
    }

    @Test
    fun `when getIvysaur assert returns 200, should return Pokemon object`() {
        enqueueEmptyResponse(200)
        stubGetIvysaur(ivysaur)

        val response = repository.getIvysaur()

        assertNotNull(response)
        assertEquals(response, ivysaur)
    }

    @Test(expected = HttpException::class)
    fun `when getIvysaur assert returns 400, then throw HttpException`() {
        enqueueEmptyResponse(400)
        stubGetIvysaur(ivysaur)
        repository.getIvysaur()
    }

    @Test(expected = AuthenticationException::class)
    fun `when getIvysaur assert returns 401, then throw HttpException`() {
        enqueueEmptyResponse(401)
        stubGetIvysaur(ivysaur)
        repository.getIvysaur()
    }

    @Test(expected = HttpException::class)
    fun `when getIvysaur assert returns 500, then throw HttpException`() {
        enqueueEmptyResponse(500)
        stubGetIvysaur(ivysaur)
        repository.getIvysaur()
    }

    private fun stubGetBulbasaur(pokemon: Pokemon) =
        whenever(repository.getBulbasaur())
            .thenReturn(pokemon)

    private fun stubGetIvysaur(pokemon: Pokemon) =
        whenever(repository.getIvysaur())
            .thenReturn(pokemon)
}