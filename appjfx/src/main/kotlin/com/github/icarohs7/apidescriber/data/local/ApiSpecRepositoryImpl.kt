package com.github.icarohs7.apidescriber.data.local

import com.github.icarohs7.apidescriber.data.entities.ApiSpec
import com.github.icarohs7.apidescriber.data.entities.EndpointSpec
import com.github.icarohs7.apidescriber.data.newEndpointSpec
import com.github.icarohs7.apidescriber.domain.JfxApiSpecRepository
import javafx.beans.property.Property
import javafx.beans.property.SimpleObjectProperty

operator fun ApiSpecRepository.Companion.unaryPlus(): JfxApiSpecRepository =
        ApiSpecRepositoryImpl()

private class ApiSpecRepositoryImpl : JfxApiSpecRepository {
    override val observable: Property<ApiSpec> by lazy { SimpleObjectProperty<ApiSpec>(ApiSpec()) }
    override val loadedApiSpec: ApiSpec get() = observable.value

    override fun addEndpointSpec(spec: EndpointSpec) {
        val currentSpec = loadedApiSpec
        val newSpec = loadedApiSpec.copy(endpoints = currentSpec.endpoints + spec)
        loadData(newSpec)
    }

    override fun removeEndpointSpec(specId: Int) {
        val endpointToBeRemoved = loadedApiSpec.endpoints.filter { it.id == specId }
        val oldEndpoints = loadedApiSpec.endpoints
        val newEndpoints = oldEndpoints - endpointToBeRemoved
        loadData(loadedApiSpec.copy(endpoints = newEndpoints))
    }

    override fun loadData(data: ApiSpec) {
        observable.value = data
    }

    override fun getOrCreateEndpointSpec(specId: Int): EndpointSpec {
        val foundSpec = loadedApiSpec.endpoints.find { it.id == specId }
        val newSpec = foundSpec ?: loadedApiSpec.newEndpointSpec()
        addEndpointSpec(newSpec)
        return newSpec
    }
}