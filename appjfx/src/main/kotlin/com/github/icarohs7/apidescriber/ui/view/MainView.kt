package com.github.icarohs7.apidescriber.ui.view

import com.github.icarohs7.apidescriber.ui.view.baseclasses.ScopedView
import tornadofx.*

class MainView : ScopedView("Api Describer") {
    override val root = hbox {
        val parentWidthProperty = widthProperty()

        vbox {
            maxWidth = Double.MAX_VALUE
            parentWidthProperty.onChange { prefWidth = it * .5 }

            add(MetadataView())
            add(EndpointSpecView())
        }


        vbox {
            maxWidth = Double.MAX_VALUE
            parentWidthProperty.onChange { prefWidth = it * .5 }

            add(PreviewView())
        }
    }
}