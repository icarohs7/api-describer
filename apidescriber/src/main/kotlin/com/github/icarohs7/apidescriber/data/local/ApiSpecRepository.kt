package com.github.icarohs7.apidescriber.data.local

import com.github.icarohs7.apidescriber.data.entities.ApiSpec
import com.github.icarohs7.apidescriber.data.entities.EndpointSpec

/**
 * Repository managing the current api spec
 * @param O The type of observable being used to emit events from the spec
 */
interface ApiSpecRepository<O> {
    /**
     * Observable emmiting new instances of the
     * loaded [ApiSpec]
     */
    val observable: O

    /**
     * Current [ApiSpec] loaded into the
     * application
     */
    val loadedApiSpec: ApiSpec

    /**
     * Add an [EndpointSpec] to the current
     * [ApiSpec], using an auto-incremented ID
     */
    fun addEndpointSpec(spec: EndpointSpec)

    /**
     * Remove an [EndpointSpec] from the current
     * [ApiSpec] with the given id
     */
    fun removeEndpointSpec(specId: Int)

    /**
     * Assign an instance of [ApiSpec] to
     * be the current one in use
     */
    fun loadData(data: ApiSpec)

    /**
     * Get a new instance of [EndpointSpec]
     * with the given id, recovering it from
     * the current [ApiSpec] if it already
     * exists or creating a new one and adding
     * it to the loaded [ApiSpec]
     */
    fun getOrCreateEndpointSpec(specId: Int): EndpointSpec

    companion object
}