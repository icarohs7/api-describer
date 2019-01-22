package com.github.icarohs7.apidescriber.data

import com.github.icarohs7.apidescriber.data.entities.ApiSpec
import com.github.icarohs7.apidescriber.data.entities.EndpointSpec
import com.github.icarohs7.apidescriber.domain.extensions.valueOr
import org.yaml.snakeyaml.DumperOptions
import org.yaml.snakeyaml.Yaml

/**
 * Serialize the api spec in yaml string
 */
fun ApiSpec.serialize(): String {
    val dumpOptions = DumperOptions()
            .apply { defaultFlowStyle = DumperOptions.FlowStyle.BLOCK }
            .apply { indent = 4 }

    return Yaml(dumpOptions).dump(this.mapify())
}

/**
 * Serialize the api spec in a [Map]
 * object
 */
fun ApiSpec.mapify(): Map<String, Any> {
    return mapOf(
            "production_server" to productionServer,
            "development_server" to developmentServer,
            "notes" to notes,
            "endpoints" to endpoints.map(EndpointSpec::mapify)
    )
}

/**
 * Return the next unique [Int] identifier
 * to be used by an endpoint
 */
fun ApiSpec.nextEndpointSpecId(): Int {
    return endpoints
            .map { it.id }
            .max()
            .valueOr(0)
            .plus(1)
}

/**
 * Serialize the endpoint spec in a [Map]
 * object
 */
fun EndpointSpec.mapify(): Map<String, Any> {
    return mapOf(
            "url" to url,
            "values" to values,
            "description" to description,
            "observations" to observations,
            "method" to method,
            "body" to body,
            "body_type" to bodyType,
            "response" to response
    )
}