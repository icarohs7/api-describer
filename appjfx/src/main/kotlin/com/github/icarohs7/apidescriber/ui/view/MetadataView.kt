package com.github.icarohs7.apidescriber.ui.view

import com.github.icarohs7.apidescriber.data.entities.ApiSpec
import com.github.icarohs7.apidescriber.domain.Injector
import com.github.icarohs7.apidescriber.domain.extensions.bidirectionalMap
import com.github.icarohs7.apidescriber.ui.view.baseclasses.ScopedView
import javafx.beans.property.Property
import org.koin.standalone.inject
import tornadofx.*

class MetadataView : ScopedView("Informações da api") {
    private val apiSpec: Property<ApiSpec> by Injector.inject("ApiSpec")

    override val root = form {
        fieldset("Dados da Api") {
            field("Servidor de produção") {
                textfield {
                    bind(apiSpec.bidirectionalMap(ApiSpec::productionServer) {
                        apiSpec.value.copy(productionServer = it)
                    })
                }
            }

            field("Servidor de desenvolvimento") {
                textfield {
                    bind(apiSpec.bidirectionalMap(ApiSpec::developmentServer) {
                        apiSpec.value.copy(developmentServer = it)
                    })
                }
            }

            field("Notas") {
                textarea {
                    prefRowCount = 3
                    bind(apiSpec.bidirectionalMap({ it.notes.joinToString("\n") }) {
                        apiSpec.value.copy(notes = it.split("\n"))
                    })
                }
            }
        }
    }
}