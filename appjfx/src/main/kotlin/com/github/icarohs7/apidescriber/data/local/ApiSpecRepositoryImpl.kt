package com.github.icarohs7.apidescriber.data.local

import com.github.icarohs7.apidescriber.data.entities.ApiSpec
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel

operator fun ApiSpecRepository.Companion.unaryPlus(): ApiSpecRepository = ApiSpecRepositoryImpl()

private class ApiSpecRepositoryImpl : ApiSpecRepository {
    override val channel: ReceiveChannel<ApiSpec> = Channel(capacity = 2)
}