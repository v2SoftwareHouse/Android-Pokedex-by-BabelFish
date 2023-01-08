package com.v2.babelfish.pokedex.feature.chainusecase.business

import com.v2.babelfish.business.dto.Output
import com.v2.babelfish.business.dto.ValueOutput
import com.v2.babelfish.business.interactor.UseCase
import com.v2.babelfish.pokedex.feature.chainusecase.domain.ChainPokemon

open class GETBulbasaurUseCase(
    private val repo: ChainUseCaseRepository
) : UseCase<Void, ChainPokemon>() {

    override fun execute(param: Void?): Output<ChainPokemon> {
        val landing = ChainPokemon()
        landing.results.add(repo.getBulbasaur())

        return ValueOutput(landing)
    }
}