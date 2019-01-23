package com.github.icarohs7.apidescriber.ui.view

import com.github.icarohs7.apidescriber.data.entities.EndpointSpec
import com.github.icarohs7.apidescriber.data.nextEndpointSpecId
import com.github.icarohs7.apidescriber.domain.ApiSpecAdapter
import com.github.icarohs7.apidescriber.domain.EndpointSpecAdapter
import com.github.icarohs7.apidescriber.domain.Injector
import com.github.icarohs7.apidescriber.domain.JfxApiSpecRepository
import javafx.geometry.Insets
import javafx.scene.layout.Background
import javafx.scene.layout.BackgroundFill
import javafx.scene.layout.CornerRadii
import javafx.scene.layout.HBox
import javafx.scene.layout.Priority
import javafx.scene.paint.Color
import javafx.util.StringConverter
import org.koin.standalone.inject
import tornadofx.*

class EndpointSpecView : View("Adicionar Endpoint") {
    private val apiSpecRepository: JfxApiSpecRepository by Injector.inject()

    override val root = form {
        fieldset("Adicionar/Editar endpoint") {
            hbox {
                val parentWidthProperty = widthProperty()

                textfield {
                    hgrow = Priority.ALWAYS
                    text = "${EndpointSpecAdapter.selectedSpec.value.id}"
                    isEditable = false
                    isDisable = true
                    parentWidthProperty.onChange { parentWidth -> prefWidth = parentWidth * .1f }

                    bind(EndpointSpecAdapter.idProperty)
                }

                combobox<EndpointSpec> {
                    maxWidth = Double.MAX_VALUE
                    parentWidthProperty.onChange { parentWidth -> prefWidth = parentWidth * .9f }

                    converter = object : StringConverter<EndpointSpec>() {
                        override fun toString(spec: EndpointSpec): String {
                            return "${spec.url} - ${spec.method}"
                        }

                        override fun fromString(string: String): EndpointSpec {
                            return EndpointSpecAdapter.selectedSpec.value
                        }
                    }

                    val initialData = apiSpecRepository.loadedApiSpec.endpoints
                    val list = observableList(*initialData.toTypedArray())
                    ApiSpecAdapter.endpointsProperty.onChange { endpointSpec -> list.setAll(endpointSpec.orEmpty()) }
                    items = list
                    bind(EndpointSpecAdapter.selectedSpec)
                    setOnAction {
                        val selected = EndpointSpecAdapter.selectedSpec.value
                        if (value != selected) EndpointSpecAdapter.selectedSpec.value = selected
                    }
                }
            }

            field("Url") {
                textfield {
                    hgrow = Priority.ALWAYS

                    bind(EndpointSpecAdapter.urlProperty)
                }
            }

            field("Valores da Url") {
                textarea {
                    prefRowCount = 3

                    bind(EndpointSpecAdapter.valuesProperty)
                }
            }

            field("Descrição") {
                textfield {
                    bind(EndpointSpecAdapter.descriptionProperty)
                }
            }

            field("Observações") {
                textfield {
                    bind(EndpointSpecAdapter.observationsProperty)
                }
            }

            field("Método") {
                textfield {
                    bind(EndpointSpecAdapter.methodProperty)
                }
            }

            field("Corpo da requisição") {
                textfield {
                    bind(EndpointSpecAdapter.bodyProperty)
                }
            }

            field("Tipo do corpo da requisição") {
                textfield {
                    bind(EndpointSpecAdapter.bodyTypeProperty)
                }
            }

            field("Corpo da resposta") {
                textfield {
                    bind(EndpointSpecAdapter.responseProperty)
                }
            }

            hbox {
                vbox { hgrow = Priority.ALWAYS }
                actionButton("Adicionar", "#2f8417") { clearEndpointSpec() }
                actionButton("Remover", "#e3000f") { removeEndpointSpec() }
                actionButton("Salvar", "#0d74bd") { saveEndpointSpec() }
            }
        }
    }

    private fun HBox.actionButton(buttonText: String, bgColor: String, onAction: () -> Unit) {
        button(buttonText) {
            spacing = 10.0
            action(onAction)
            setPrefSize(100.0, 40.0)

            textFill = Color.valueOf("fff")
            background = Background(BackgroundFill(Color.valueOf(bgColor), CornerRadii(5.0), Insets.EMPTY))
        }
    }

    private fun removeEndpointSpec() {
        apiSpecRepository.removeEndpointSpec(EndpointSpecAdapter.selectedSpec.value.id)
        clearEndpointSpec()
    }

    private fun saveEndpointSpec() {
        apiSpecRepository.addEndpointSpec(EndpointSpecAdapter.selectedSpec.value)
        clearEndpointSpec()
    }

    private fun clearEndpointSpec() {
        EndpointSpecAdapter.selectedSpec.value = EndpointSpec(id = apiSpecRepository.loadedApiSpec.nextEndpointSpecId())
    }
}
