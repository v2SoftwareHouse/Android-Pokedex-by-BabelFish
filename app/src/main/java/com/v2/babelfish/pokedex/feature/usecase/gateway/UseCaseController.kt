package com.v2.babelfish.pokedex.feature.usecase.gateway

import com.v2.babelfish.mvvm.Controller

interface UseCaseController : Controller {
    fun doFetch(channelName: String)
}