package com.v2.babelfish.pokedex.feature.chainusecase.gateway

import com.v2.babelfish.mvvm.Controller

interface ChainUseCaseController : Controller {
    fun doFetch(channelName: String)
}