package com.github.icarohs7.apidescriber.ui.view

import com.github.icarohs7.apidescriber.domain.ApiSpecAdapter
import com.github.icarohs7.apidescriber.domain.Converters
import com.github.icarohs7.apidescriber.ui.view.baseclasses.ScopedView
import tornadofx.*

class MetadataView : ScopedView("Informações da api") {
    override val root = form {
        fieldset("Dados da Api") {
            field("Servidor de produção") {
                textfield {
                    bind(ApiSpecAdapter.productionServerProperty)
                }
            }

            field("Servidor de desenvolvimento") {
                textfield {
                    bind(ApiSpecAdapter.developmentServerProperty)
                }
            }

            field("Notas") {
                textarea {
                    prefRowCount = 3
                    bind(ApiSpecAdapter.notesProperty, converter = Converters.listStringToString())
                }
            }
        }
    }
}