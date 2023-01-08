package com.v2.babelfish.pokedex.plugin

import com.v2.babelfish.pokedex.plugin.api.BaseRepository
import okhttp3.mockwebserver.MockWebServer

abstract class AbstractRepositoryTest<T : BaseRepository> {
    protected val server = MockWebServer()
    protected lateinit var repository: T

    open fun setup() {
        server.start()
        setupRepository()
    }

    abstract fun setupRepository()

    protected open fun setupUrl(): String {
        val baseUrl = "/"
        return server.url(baseUrl).toString()
    }
}