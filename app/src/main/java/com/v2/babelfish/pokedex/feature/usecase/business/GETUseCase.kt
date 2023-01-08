package com.v2.babelfish.pokedex.feature.usecase.business

import com.v2.babelfish.business.dto.Output
import com.v2.babelfish.business.dto.ValueOutput
import com.v2.babelfish.business.interactor.UseCase
import com.v2.babelfish.pokedex.feature.usecase.domain.Pokemon

open class GETUseCase(
    private val repo: UseCaseRepository
) : UseCase<String, Pokemon>() {

    override fun execute(param: String?): Output<Pokemon> {
        val pokemon = repo.doFetch(param)
        return ValueOutput(pokemon)
    }
}