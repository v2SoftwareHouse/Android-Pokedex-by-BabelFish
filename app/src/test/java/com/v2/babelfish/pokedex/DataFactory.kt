package com.v2.babelfish.pokedex

import java.time.LocalDate
import java.util.UUID
import java.util.concurrent.ThreadLocalRandom
import com.v2.babelfish.pokedex.feature.usecase.domain.Pokemon as UseCaseDataPokemon
import com.v2.babelfish.pokedex.feature.sequenceusecase.domain.Pokemon as SequenceUseCaseDataPokemon
import com.v2.babelfish.pokedex.feature.chainusecase.domain.Pokemon as ChainUseCaseDataPokemon
import com.v2.babelfish.pokedex.feature.handleerror.domain.Pokemon as ErrorUseCaseDataPokemon

class DataFactory {
    companion object Factory {

        fun randomUuid() = UUID.randomUUID().toString()

        private fun randomInt() = ThreadLocalRandom.current().nextInt(0, 1000 + 1)

        private fun randomDouble() = randomInt().toDouble()

        private fun randomLong() = randomInt().toLong()

        private fun randomDate() = LocalDate.ofEpochDay(randomLong())

        private fun randomBoolean() = Math.random() < 0.5

        fun mockUseCaseDataPokemon() = UseCaseDataPokemon(randomUuid())
        fun mockErrorUseCaseDataPokemon() = ErrorUseCaseDataPokemon(randomUuid())
        fun mockBulbasaurSequenceUseCaseData() = SequenceUseCaseDataPokemon("Bulbasaur")
        fun mockIvysaurSequenceUseCaseData() = SequenceUseCaseDataPokemon("Ivysaur")
        fun mockVenusaurSequenceUseCaseData() = SequenceUseCaseDataPokemon("Venusaur")

        fun mockBulbasaurChainUseCaseData() = ChainUseCaseDataPokemon("Bulbasaur")
        fun mockIvysaurChainUseCaseData() = ChainUseCaseDataPokemon("Ivysaur")




//        fun mockLanding() = Landing(randomInt(), randomUuid(), mockPokemonList())
//
//        fun mockEmptyLanding() = Landing(randomInt(), randomUuid(), mutableListOf())
//
//        fun mockPokemon() = Pokemon(randomUuid(), randomUuid(), randomBoolean())
//
//        fun mockPokemonList() = (0..10).map { mockPokemon() }.toMutableList()
    }
}