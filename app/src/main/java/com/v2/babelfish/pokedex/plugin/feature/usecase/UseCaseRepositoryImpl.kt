package com.v2.babelfish.pokedex.plugin.feature.usecase

import com.v2.babelfish.pokedex.feature.usecase.business.UseCaseRepository
import com.v2.babelfish.pokedex.feature.usecase.domain.Pokemon
import com.v2.babelfish.pokedex.plugin.api.BaseRepository
import com.v2.babelfish.pokedex.plugin.api.UseCasePokedexAPI
import com.v2.babelfish.pokedex.plugin.api.UseCasePokedexAPIBuilder
import okhttp3.Interceptor
import okhttp3.logging.HttpLoggingInterceptor

open class UseCaseRepositoryImpl(url: String) : BaseRepository(url), UseCaseRepository {

    override fun doFetch(name: String?): Pokemon? {
        return getBodyOrThrow(getService().getPokemon(name))
    }

    override fun getService(interceptors: List<Interceptor>): UseCasePokedexAPI {
        val loggingInterceptor =
            HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }

        val list = mutableListOf(loggingInterceptor)
        return UseCasePokedexAPIBuilder(baseUrl, list).build()
    }
}