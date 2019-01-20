package com.github.icarohs7.apidescriber.data.local

import com.github.icarohs7.apidescriber.data.entities.ApiSpec
import kotlinx.coroutines.channels.ReceiveChannel

interface ApiSpecRepository {
    val channel: ReceiveChannel<ApiSpec>

    companion object
}