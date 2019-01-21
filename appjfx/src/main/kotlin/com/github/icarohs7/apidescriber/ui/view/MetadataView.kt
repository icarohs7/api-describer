package com.github.icarohs7.apidescriber.ui.view

import com.github.icarohs7.apidescriber.ui.view.baseclasses.ScopedView
import tornadofx.*

class MetadataView : ScopedView("Informações da api") {
    override val root = form {
        fieldset("Dados da Api") {
            field("Servidor de produção") {
                textfield()
            }

            field("Servidor de desenvolvimento") {
                textfield()
            }

            field("Notas") {
                textarea()
            }
        }
    }
}