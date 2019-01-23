package com.github.icarohs7.apidescriber.data.entities

/**
 * Class representing the complete API spec,
 * serializable into a YML file
 */
data class ApiSpec(
        val productionServer: String = "",
        val developmentServer: String = "",
        val notes: List<String> = emptyList(),
        val endpoints: List<EndpointSpec> = emptyList()
) {
    companion object
}