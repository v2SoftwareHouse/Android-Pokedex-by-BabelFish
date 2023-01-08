package com.v2.babelfish.pokedex.plugin.feature.handleerror

import com.v2.babelfish.pokedex.feature.handleerror.business.ErrorUseCaseRepository
import com.v2.babelfish.pokedex.feature.handleerror.domain.Pokemon
import com.v2.babelfish.pokedex.plugin.api.BaseRepository
import com.v2.babelfish.pokedex.plugin.api.ErrorUseCasePokedexAPI
import com.v2.babelfish.pokedex.plugin.api.ErrorUseCasePokedexAPIBuilder
import okhttp3.Interceptor
import okhttp3.logging.HttpLoggingInterceptor

open class ErrorUseCaseRepositoryImpl(url: String) :
    BaseRepository(url), ErrorUseCaseRepository {

    override fun doFetch(name: String?): Pokemon? {
        return getBodyOrThrow(getService().getPokemon(name))
    }

    override fun getService(interceptors: List<Interceptor>): ErrorUseCasePokedexAPI {
        val loggingInterceptor =
            HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }

        val list = mutableListOf(loggingInterceptor)
        return ErrorUseCasePokedexAPIBuilder(baseUrl, list).build()
    }
}