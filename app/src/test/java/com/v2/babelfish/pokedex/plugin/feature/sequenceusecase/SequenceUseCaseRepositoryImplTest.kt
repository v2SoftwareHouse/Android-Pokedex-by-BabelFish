package com.v2.babelfish.pokedex.plugin.feature.sequenceusecase

import com.v2.babelfish.business.exception.AuthenticationException
import com.v2.babelfish.business.exception.HttpException
import com.nhaarman.mockitokotlin2.spy
import com.nhaarman.mockitokotlin2.whenever
import com.v2.babelfish.pokedex.DataFactory
import com.v2.babelfish.pokedex.feature.sequenceusecase.domain.Pokemon
import com.v2.babelfish.pokedex.plugin.feature.LoggedInRepositoryTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test

class SequenceUseCaseRepositoryImplTest : LoggedInRepositoryTest<SequenceUseCaseRepositoryImpl>() {
    private val bulbasaur = DataFactory.mockBulbasaurSequenceUseCaseData()
    private val ivysaur = DataFactory.mockIvysaurSequenceUseCaseData()
    private val venusaur = DataFactory.mockVenusaurSequenceUseCaseData()

    override fun setupRepository(httpUrl: String) {
        repository = spy(SequenceUseCaseRepositoryImpl(httpUrl))
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

    @Test
    fun `when getVenusaur assert returns 200, should return Pokemon object`() {
        enqueueEmptyResponse(200)
        stubGetVenusaur(venusaur)

        val response = repository.getVenusaur()

        assertNotNull(response)
        assertEquals(response, venusaur)
    }

    @Test(expected = HttpException::class)
    fun `when getVenusaur assert returns 400, then throw HttpException`() {
        enqueueEmptyResponse(400)
        stubGetVenusaur(venusaur)
        repository.getVenusaur()
    }

    @Test(expected = AuthenticationException::class)
    fun `when getVenusaur assert returns 401, then throw HttpException`() {
        enqueueEmptyResponse(401)
        stubGetVenusaur(venusaur)
        repository.getVenusaur()
    }

    @Test(expected = HttpException::class)
    fun `when getVenusaur assert returns 500, then throw HttpException`() {
        enqueueEmptyResponse(500)
        stubGetVenusaur(venusaur)
        repository.getVenusaur()
    }

    private fun stubGetBulbasaur(pokemon: Pokemon) =
        whenever(repository.getBulbasaur())
            .thenReturn(pokemon)

    private fun stubGetIvysaur(pokemon: Pokemon) =
        whenever(repository.getIvysaur())
            .thenReturn(pokemon)

    private fun stubGetVenusaur(pokemon: Pokemon) =
        whenever(repository.getVenusaur())
            .thenReturn(pokemon)
}