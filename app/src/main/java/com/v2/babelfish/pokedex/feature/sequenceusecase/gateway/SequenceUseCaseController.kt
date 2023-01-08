package com.v2.babelfish.pokedex.feature.sequenceusecase.gateway

import com.v2.babelfish.mvvm.Controller

interface SequenceUseCaseController : Controller {
    fun doFetch(channelName: String)
}