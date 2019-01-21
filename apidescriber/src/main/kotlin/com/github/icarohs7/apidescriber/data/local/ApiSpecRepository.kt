package com.github.icarohs7.apidescriber.data.local

import com.github.icarohs7.apidescriber.data.entities.ApiSpec
import com.github.icarohs7.apidescriber.data.entities.EndpointSpec
import kotlinx.coroutines.channels.ReceiveChannel

interface ApiSpecRepository {
    val channel: ReceiveChannel<ApiSpec>
    val cachedData: ApiSpec

    fun addEndpointSpec(spec: EndpointSpec)

    suspend fun getSavedData()
    suspend fun saveData()
    fun loadData(data: ApiSpec)

    companion object
}