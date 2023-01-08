package com.v2.babelfish.pokedex.plugin.api

import com.google.gson.Gson
import okhttp3.Interceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PokedexAPIBuilder(baseUrl: String?, interceptors: List<Interceptor> = emptyList()) :
    AbstractBuilder<PokedexAPI>(baseUrl, interceptors) {

    override fun build(): PokedexAPI {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(createHttpClient())
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .build()
            .create(PokedexAPI::class.java)
    }
}

class ChainUseCasePokedexAPIBuilder(
    baseUrl: String?,
    interceptors: List<Interceptor> = emptyList()
) :
    AbstractBuilder<ChainUseCasePokedexAPI>(baseUrl, interceptors) {

    override fun build(): ChainUseCasePokedexAPI {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(createHttpClient())
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .build()
            .create(ChainUseCasePokedexAPI::class.java)
    }
}

class SequenceUseCasePokedexAPIBuilder(
    baseUrl: String?,
    interceptors: List<Interceptor> = emptyList()
) :
    AbstractBuilder<SequenceUseCasePokedexAPI>(baseUrl, interceptors) {
    override fun build(): SequenceUseCasePokedexAPI {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(createHttpClient())
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .build()
            .create(SequenceUseCasePokedexAPI::class.java)
    }
}

class UseCasePokedexAPIBuilder(baseUrl: String?, interceptors: List<Interceptor> = emptyList()) :
    AbstractBuilder<UseCasePokedexAPI>(baseUrl, interceptors) {
    override fun build(): UseCasePokedexAPI {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(createHttpClient())
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .build()
            .create(UseCasePokedexAPI::class.java)
    }
}

class ErrorUseCasePokedexAPIBuilder(
    baseUrl: String?,
    interceptors: List<Interceptor> = emptyList()
) :
    AbstractBuilder<ErrorUseCasePokedexAPI>(baseUrl, interceptors) {
    override fun build(): ErrorUseCasePokedexAPI {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(createHttpClient())
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .build()
            .create(ErrorUseCasePokedexAPI::class.java)
    }
}


