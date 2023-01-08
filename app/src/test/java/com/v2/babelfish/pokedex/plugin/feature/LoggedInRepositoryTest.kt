package com.v2.babelfish.pokedex.plugin.feature

import com.v2.babelfish.pokedex.plugin.AbstractRepositoryTest
import com.v2.babelfish.pokedex.plugin.api.BaseRepository
import okhttp3.mockwebserver.MockResponse
import org.junit.After
import org.junit.Before
import org.junit.Test

abstract class LoggedInRepositoryTest<T : BaseRepository> : AbstractRepositoryTest<T>() {
    protected val token = "to"

    @Before
    override fun setup() {
        super.setup()
    }

    final override fun setupRepository() {
        val httpUrl = setupUrl()
        setupRepository(httpUrl)
    }

    @After
    fun teardown() {
        server.shutdown()
    }

    @Test
    fun `when auth is required, then authorization header is set`() {
        enqueueEmptyResponse(200)

        repository.dumbRequest()
    }

    abstract fun setupRepository(httpUrl: String)

    protected fun enqueueEmptyResponse(code: Int) {
        val response = MockResponse().apply {
            setResponseCode(code)
            setBody("{}")
        }

        server.enqueue(response)
    }

    protected fun enqueueResponse(code: Int, body: String) {
        val response = MockResponse().apply {
            setResponseCode(code)
            setBody(body)
        }

        server.enqueue(response)
    }
}