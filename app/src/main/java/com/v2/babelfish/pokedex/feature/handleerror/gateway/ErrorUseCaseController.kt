package com.v2.babelfish.pokedex.feature.handleerror.gateway

import com.v2.babelfish.mvvm.Controller

interface ErrorUseCaseController : Controller {
    fun doFetch(channelName: String)
}