package com.v2.babelfish.pokedex.feature.handleerror.business

import com.v2.babelfish.business.dto.Output
import com.v2.babelfish.business.dto.ValueOutput
import com.v2.babelfish.business.interactor.UseCase
import com.v2.babelfish.pokedex.feature.handleerror.domain.Pokemon

open class ErrorUseCase(
    private val repo: ErrorUseCaseRepository
) : UseCase<String, Pokemon>() {

    override fun execute(param: String?): Output<Pokemon> {
        val pokemon = repo.doFetch(param)
        return ValueOutput(pokemon)
    }
}