package com.github.icarohs7.apidescriber.ui.view

import com.github.icarohs7.apidescriber.data.entities.ApiSpec
import com.github.icarohs7.apidescriber.data.entities.EndpointSpec
import com.github.icarohs7.apidescriber.data.nextEndpointSpecId
import com.github.icarohs7.apidescriber.domain.Injector
import com.github.icarohs7.apidescriber.domain.extensions.bidirectionalMap
import com.github.icarohs7.apidescriber.domain.extensions.valueOr
import javafx.beans.property.Property
import javafx.geometry.Insets
import javafx.scene.layout.Background
import javafx.scene.layout.BackgroundFill
import javafx.scene.layout.CornerRadii
import javafx.scene.layout.HBox
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
            hbox {
                val parentWidthProperty = widthProperty()

                textfield {
                    hgrow = Priority.ALWAYS
                    text = "${endpointSpec.value.id}"
                    isEditable = false
                    isDisable = true
                    parentWidthProperty.onChange { parentWidth -> prefWidth = parentWidth * .1f }
                    endpointSpec.onChange { endpoint -> text = "${endpoint?.id.valueOr(1)}" }
                }

                combobox<String> {
                    maxWidth = Double.MAX_VALUE

                    parentWidthProperty.onChange { parentWidth -> prefWidth = parentWidth * .9f }
                    val list = observableList(*apiSpec.value.endpoints.toTypedArray())
                    apiSpec.onChange { list.setAll(it?.endpoints.orEmpty()) }
                    list.onChange { items = list.map { endpoint -> "${endpoint.url} - ${endpoint.method}" }.observable() }
                }
            }

            field("Url") {
                textfield {
                    hgrow = Priority.ALWAYS
                    bind(endpointSpec.bidirectionalMap(EndpointSpec::url) {
                        endpointSpec.value.copy(url = it)
                    })
                }
            }

            field("Valores da Url") {
                textarea {
                    prefRowCount = 3
                    bind(endpointSpec.bidirectionalMap(EndpointSpec::values) {
                        endpointSpec.value.copy(values = it)
                    })
                }
            }

            field("Descrição") {
                textfield {
                    bind(endpointSpec.bidirectionalMap(EndpointSpec::description) {
                        endpointSpec.value.copy(description = it)
                    })
                }
            }

            field("Observações") {
                textfield {
                    bind(endpointSpec.bidirectionalMap(EndpointSpec::observations) {
                        endpointSpec.value.copy(observations = it)
                    })
                }
            }

            field("Método") {
                textfield {
                    bind(endpointSpec.bidirectionalMap(EndpointSpec::method) {
                        endpointSpec.value.copy(method = it)
                    })
                }
            }

            field("Corpo da requisição") {
                textfield {
                    bind(endpointSpec.bidirectionalMap(EndpointSpec::body) {
                        endpointSpec.value.copy(body = it)
                    })
                }
            }

            field("Tipo do corpo da requisição") {
                textfield {
                    bind(endpointSpec.bidirectionalMap(EndpointSpec::bodyType) {
                        endpointSpec.value.copy(bodyType = it)
                    })
                }
            }

            field("Corpo da resposta") {
                textfield {
                    bind(endpointSpec.bidirectionalMap(EndpointSpec::response) {
                        endpointSpec.value.copy(response = it)
                    })
                }
            }

            hbox {
                vbox { hgrow = Priority.ALWAYS }
                actionButton("gmi-add", "#2f8417") { clearEndpointSpec() }
                actionButton("gmi-remove", "#e3000f") { removeEndpointSpec() }
                actionButton("gmi-check", "#0d74bd") { saveEndpointSpec() }
            }
        }
    }

    private fun HBox.actionButton(iconName: String, bgColor: String, onAction: () -> Unit) {
        val buttonIcon = FontIcon(iconName).apply { iconColor = Paint.valueOf("#fff") }
        button(graphic = buttonIcon) {
            spacing = 10.0
            action(onAction)
            setPrefSize(40.0, 40.0)
            background = Background(BackgroundFill(Color.valueOf(bgColor), CornerRadii(5.0), Insets.EMPTY))
        }
    }

    private fun removeEndpointSpec() {
        val oldEndpoints = apiSpec.value.endpoints
        val entryId = endpointSpec.value.id
        val newEndpoints = oldEndpoints.filterNot { it.id == entryId }

        apiSpec.value = apiSpec.value.copy(endpoints = newEndpoints)
        clearEndpointSpec()
    }

    private fun saveEndpointSpec() {
        val api = apiSpec.value
        apiSpec.value = api.copy(endpoints = api.endpoints + endpointSpec.value)
        clearEndpointSpec()
    }

    private fun clearEndpointSpec() {
        endpointSpec.value = EndpointSpec(id = apiSpec.value.nextEndpointSpecId())
    }
}
