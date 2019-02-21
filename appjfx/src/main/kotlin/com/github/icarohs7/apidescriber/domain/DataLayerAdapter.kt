package com.github.icarohs7.apidescriber.domain

import com.github.icarohs7.apidescriber.data.entities.ApiSpec
import com.github.icarohs7.apidescriber.data.entities.EndpointSpec
import javafx.beans.property.Property
import javafx.beans.property.SimpleObjectProperty
import javafx.util.StringConverter
import org.koin.standalone.inject
import tornadofx.*

/**
 * Object exposing JavaFx properties bound to the
 * properties of the loaded [ApiSpec], updating
 * the value when any one changes
 */
object ApiSpecAdapter {
    private val apiSpecRepository: JfxApiSpecRepository by Injector.inject()

    val productionServerProperty: Property<String> = createProp(
            { apiSpecRepository.loadData(this.copy(productionServer = it)) },
            { this.productionServer })

    val developmentServerProperty: Property<String> = createProp(
            { apiSpecRepository.loadData(this.copy(developmentServer = it)) },
            { this.developmentServer })

    val notesProperty: Property<List<String>> = createProp(
            { apiSpecRepository.loadData(this.copy(notes = it)) },
            { this.notes })

    val endpointsProperty: Property<List<EndpointSpec>> = createProp(
            { apiSpecRepository.loadData(this.copy(endpoints = it)) },
            { this.endpoints })

    private fun <T> createProp(
            setter: ApiSpec.(T) -> Unit,
            getter: ApiSpec.() -> T
    ): Property<T> {
        val getSpecPropertyValue = { getter(apiSpecRepository.loadedApiSpec) }
        val setSpecPropertyValue = { value: T -> setter(apiSpecRepository.loadedApiSpec, value) }

        val prop = object : SimpleObjectProperty<T>() {
            override fun setValue(v: T) {
                super.setValue(v)
                if (getSpecPropertyValue() != v) setSpecPropertyValue(v)
            }
        }

        apiSpecRepository
                .observable
                .onChange { newValue -> newValue?.let { spec -> prop.value = getter(spec) } }

        return prop
    }
}

/**
 * Object exposing JavaFx properties bound to the
 * properties of the selected [EndpointSpec], updating
 * the value when any one changes
 */
object EndpointSpecAdapter {
    val selectedSpec: Property<EndpointSpec> = SimpleObjectProperty(EndpointSpec())

    val idProperty: Property<Int> = createProp(
            { Unit },
            { this.id })

    val urlProperty: Property<String> = createProp(
            { selectedSpec.value = this.copy(url = it) },
            { this.url })

    val valuesProperty: Property<String> = createProp(
            { selectedSpec.value = this.copy(values = it) },
            { this.values })

    val descriptionProperty: Property<String> = createProp(
            { selectedSpec.value = this.copy(description = it) },
            { this.description })

    val observationsProperty: Property<String> = createProp(
            { selectedSpec.value = this.copy(observations = it) },
            { this.observations })

    val methodProperty: Property<String> = createProp(
            { selectedSpec.value = this.copy(method = it) },
            { this.method })

    val bodyProperty: Property<String> = createProp(
            { selectedSpec.value = this.copy(body = it) },
            { this.body })

    val bodyTypeProperty: Property<String> = createProp(
            { selectedSpec.value = this.copy(bodyType = it) },
            { this.bodyType })

    val responseProperty: Property<String> = createProp(
            { selectedSpec.value = this.copy(response = it) },
            { this.response })

    private fun <T> createProp(
            setter: EndpointSpec.(T) -> Unit,
            getter: EndpointSpec.() -> T
    ): Property<T> {
        val getSpecPropertyValue = { getter(selectedSpec.value) }
        val setSpecPropertyValue = { value: T -> setter(selectedSpec.value, value) }

        val prop = object : SimpleObjectProperty<T>() {
            override fun setValue(v: T) {
                super.setValue(v)
                if (getSpecPropertyValue() != v) setSpecPropertyValue(v)
            }
        }

        selectedSpec.onChange { newValue -> newValue?.let { spec -> prop.value = getter(spec) } }

        return prop
    }
}

object Converters {
    fun listStringToString(): StringConverter<List<String>> {
        return object : StringConverter<List<String>>() {
            override fun toString(list: List<String>?): String {
                return list.orEmpty().joinToString("\n")
            }

            override fun fromString(string: String?): List<String> {
                return string.orEmpty().split("\n")
            }
        }
    }
}