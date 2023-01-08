package com.v2.babelfish.pokedex.feature.chainusecase.business


import com.v2.babelfish.business.dto.Output
import com.v2.babelfish.business.dto.ValueOutput
import com.v2.babelfish.business.interactor.UseCase
import com.v2.babelfish.pokedex.feature.chainusecase.domain.ChainPokemon

open class GETVenusaurUseCase(
    private val repo: ChainUseCaseRepository
) : UseCase<ChainPokemon, ChainPokemon>() {

    override fun execute(param: ChainPokemon?): Output<ChainPokemon> {
        param?.results?.add(repo.getIvysaur())
        return ValueOutput(param)
    }
}