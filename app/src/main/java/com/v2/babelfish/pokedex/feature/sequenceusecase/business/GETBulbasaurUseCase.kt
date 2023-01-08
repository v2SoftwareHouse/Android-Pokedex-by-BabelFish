package com.v2.babelfish.pokedex.feature.sequenceusecase.business

import com.v2.babelfish.business.dto.Output
import com.v2.babelfish.business.dto.ValueOutput
import com.v2.babelfish.business.interactor.UseCase
import com.v2.babelfish.pokedex.feature.sequenceusecase.domain.Pokemon

open class GETBulbasaurUseCase(
    private val repo: SequenceUseCaseRepository
) : UseCase<Void, Pokemon>() {

    override fun execute(param: Void?): Output<Pokemon> {
        val landing = repo.getBulbasaur()
        return ValueOutput(landing)
    }
}