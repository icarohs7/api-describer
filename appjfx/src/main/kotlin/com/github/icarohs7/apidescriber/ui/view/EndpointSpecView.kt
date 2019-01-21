package com.github.icarohs7.apidescriber.ui.view

import com.github.icarohs7.apidescriber.data.entities.ApiSpec
import com.github.icarohs7.apidescriber.data.entities.EndpointSpec
import com.github.icarohs7.apidescriber.domain.Ext1
import com.github.icarohs7.apidescriber.domain.Injector
import com.github.icarohs7.apidescriber.domain.extensions.bidirectionalMap
import javafx.beans.property.Property
import javafx.geometry.Insets
import javafx.scene.control.Control
import javafx.scene.layout.Background
import javafx.scene.layout.BackgroundFill
import javafx.scene.layout.CornerRadii
import javafx.scene.layout.Priority
import javafx.scene.paint.Color
import javafx.scene.paint.Paint
import org.koin.standalone.inject
import org.kordamp.ikonli.javafx.FontIcon
import tornadofx.*

class EndpointSpecView : View("Adicionar Endpoint") {
    private val endpointSpec: Property<EndpointSpec> by Injector.inject("EndpointSpec")
    private val apiSpec: Property<ApiSpec> by Injector.inject("ApiSpec")

    override val root = form {
        fieldset("Adicionar/Editar endpoint") {
            combobox<String> {
                maxWidth = Double.MAX_VALUE

                val list = observableList(*apiSpec.value.endpoints.toTypedArray())
                apiSpec.onChange { list.setAll(it?.endpoints.orEmpty()) }
                list.onChange { items = list.map { "${it.url}" }.observable() }
            }

            field("Url") {
                textfield(endpointSpec.bidirectionalMap(EndpointSpec::url) {
                    endpointSpec.value.copy(url = it)
                })
            }

            field("Valores da Url") {
                textarea {
                    prefRowCount = 3
                }
            }

            field("Descrição") {
                textfield(endpointSpec.bidirectionalMap(EndpointSpec::description) {
                    endpointSpec.value.copy(description = it)
                })
            }

            field("Observações") {
                textfield(endpointSpec.bidirectionalMap(EndpointSpec::observations) {
                    endpointSpec.value.copy(observations = it)
                })
            }

            field("Método") {
                textfield(endpointSpec.bidirectionalMap(EndpointSpec::method) {
                    endpointSpec.value.copy(method = it)
                })
            }

            field("Corpo da requisição") {
                textfield(endpointSpec.bidirectionalMap(EndpointSpec::body) {
                    endpointSpec.value.copy(body = it)
                })
            }

            field("Tipo do corpo da requisição") {
                textfield(endpointSpec.bidirectionalMap(EndpointSpec::bodyType) {
                    endpointSpec.value.copy(bodyType = it)
                })
            }

            field("Corpo da resposta") {
                textfield(endpointSpec.bidirectionalMap(EndpointSpec::response) {
                    endpointSpec.value.copy(response = it)
                })
            }

            hbox {
                vbox {
                    hgrow = Priority.ALWAYS
                }

                val defSize = { c: Control -> c.setPrefSize(40.0, 40.0) }
                val defBgColor: Ext1<Control, String> = { s: String ->
                    background = Background(BackgroundFill(Color.valueOf(s), CornerRadii(5.0), Insets.EMPTY))
                }
                val colorize = { i: FontIcon -> i.apply { iconColor = Paint.valueOf("#fff") } }

                button(graphic = colorize(FontIcon("gmi-add"))) {
                    spacing = 10.0
                    action(::newEndpointSpec)
                    defSize(this)
                    this.defBgColor("#2f8417")
                }
                button(graphic = colorize(FontIcon("gmi-remove"))) {
                    spacing = 10.0
                    action(::removeEndpointSpec)
                    defSize(this)
                    this.defBgColor("#e3000f")
                }
                button(graphic = colorize(FontIcon("gmi-check"))) {
                    spacing = 10.0
                    action(::saveEndpointSpec)
                    defSize(this)
                    this.defBgColor("#0d74bd")
                }
            }
        }
    }

    private fun newEndpointSpec() {
        endpointSpec.value = EndpointSpec()
    }

    private fun removeEndpointSpec() {

    }

    private fun saveEndpointSpec() {
        val api = apiSpec.value
        apiSpec.value = api.copy(endpoints = api.endpoints + endpointSpec.value)
        newEndpointSpec()
    }
}
