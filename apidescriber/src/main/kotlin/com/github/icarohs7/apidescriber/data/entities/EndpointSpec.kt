package com.github.icarohs7.apidescriber.data.entities

/**
 * Class representing the spec of a single
 * endpoint within an [ApiSpec]
 */
data class EndpointSpec(
        val url: String = "",
        val values: Map<String, String> = emptyMap(),
        val description: String = "",
        val observations: String = "",
        val method: String = "",
        val body: String = "",
        val bodyType: String = "",
        val response: String = ""
)