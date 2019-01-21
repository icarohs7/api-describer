package com.github.icarohs7.apidescriber.ui.view

import com.github.icarohs7.apidescriber.data.entities.ApiSpec
import com.github.icarohs7.apidescriber.domain.Injector
import com.github.icarohs7.apidescriber.domain.extensions.bidirectionalMap
import com.github.icarohs7.apidescriber.ui.view.baseclasses.ScopedView
import javafx.beans.property.Property
import org.koin.standalone.inject
import tornadofx.*

class MetadataView : ScopedView("Informações da api") {
    private val spec: Property<ApiSpec> by Injector.inject("ApiSpec")

    override val root = form {
        fieldset("Dados da Api") {
            field("Servidor de produção") {
                textfield(spec.bidirectionalMap(ApiSpec::productionServer) {
                    spec.value.copy(productionServer = it)
                })
            }

            field("Servidor de desenvolvimento") {
                textfield(spec.bidirectionalMap(ApiSpec::developmentServer) {
                    spec.value.copy(developmentServer = it)
                })
            }

            field("Notas") {
                textarea(spec.bidirectionalMap({ it.notes.joinToString("\n\n") }) {
                    spec.value.copy(notes = it.split("\n\n"))
                }) {
                    prefRowCount = 3
                }
            }
        }
    }
}