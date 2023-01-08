package com.v2.babelfish.pokedex.plugin.api

import androidx.annotation.VisibleForTesting
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface UseCasePokedexAPI : PokedexAPI {
    @GET("pokemon/")
    fun getPokemon(@Query("name") name: String?): Call<com.v2.babelfish.pokedex.feature.usecase.domain.Pokemon>
}

interface SequenceUseCasePokedexAPI : PokedexAPI {
    @GET("pokemon/bulbasaur")
    fun getBulbasaur(): Call<com.v2.babelfish.pokedex.feature.sequenceusecase.domain.Pokemon>

    @GET("pokemon/ivysaur")
    fun getIvysaur(): Call<com.v2.babelfish.pokedex.feature.sequenceusecase.domain.Pokemon>

    @GET("pokemon/venusaur")
    fun getVenusaur(): Call<com.v2.babelfish.pokedex.feature.sequenceusecase.domain.Pokemon>
}

interface ChainUseCasePokedexAPI : PokedexAPI {
    @GET("pokemon/bulbasaur")
    fun getBulbasaur(): Call<com.v2.babelfish.pokedex.feature.chainusecase.domain.Pokemon>

    @GET("pokemon/ivysaur")
    fun getIvysaur(): Call<com.v2.babelfish.pokedex.feature.chainusecase.domain.Pokemon>
}

interface ErrorUseCasePokedexAPI : PokedexAPI {
    @GET("pokemon/name")
    fun getPokemon(@Query("name") name: String?): Call<com.v2.babelfish.pokedex.feature.handleerror.domain.Pokemon>
}

interface PokedexAPI {

    @GET("test")
    @VisibleForTesting
    fun dumbRequest(): Call<Any?>
}