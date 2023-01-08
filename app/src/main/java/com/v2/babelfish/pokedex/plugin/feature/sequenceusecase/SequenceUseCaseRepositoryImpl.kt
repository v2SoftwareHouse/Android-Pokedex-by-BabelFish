package com.v2.babelfish.pokedex.plugin.feature.sequenceusecase

import com.v2.babelfish.pokedex.feature.sequenceusecase.business.SequenceUseCaseRepository
import com.v2.babelfish.pokedex.feature.sequenceusecase.domain.Pokemon
import com.v2.babelfish.pokedex.plugin.api.BaseRepository
import com.v2.babelfish.pokedex.plugin.api.SequenceUseCasePokedexAPI
import com.v2.babelfish.pokedex.plugin.api.SequenceUseCasePokedexAPIBuilder
import okhttp3.Interceptor
import okhttp3.logging.HttpLoggingInterceptor

open class SequenceUseCaseRepositoryImpl(url: String) : BaseRepository(url),
    SequenceUseCaseRepository {

    override fun getBulbasaur(): Pokemon? {
        return getBodyOrThrow(getService().getBulbasaur())
    }

    override fun getIvysaur(): Pokemon? {
        return getBodyOrThrow(getService().getIvysaur())
    }

    override fun getVenusaur(): Pokemon? {
        return getBodyOrThrow(getService().getVenusaur())
    }

    override fun getService(interceptors: List<Interceptor>): SequenceUseCasePokedexAPI {
        val loggingInterceptor =
            HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }

        val list = mutableListOf(loggingInterceptor)
        return SequenceUseCasePokedexAPIBuilder(baseUrl, list).build()
    }
}