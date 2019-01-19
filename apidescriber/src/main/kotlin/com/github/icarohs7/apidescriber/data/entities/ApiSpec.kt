package com.github.icarohs7.apidescriber.data.entities

data class ApiSpec(
        val productionServer: String = "",
        val developmentServer: String = "",
        val notes: List<String> = emptyList(),
        val endpoints: List<EndpointSpec> = emptyList()
)