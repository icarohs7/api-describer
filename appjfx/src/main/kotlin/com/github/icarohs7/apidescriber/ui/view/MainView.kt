package com.github.icarohs7.apidescriber.ui.view

import tornadofx.*

class MainView : ScopedView("Api Describer") {
    override val root = hbox {
        val parentWidthProperty = widthProperty()

        vbox {
            maxWidth = Double.MAX_VALUE
            parentWidthProperty.addListener { _, _, newValue -> prefWidth = newValue.toDouble() * .5 }

            add(MetadataView())
            add(EndpointSpecView())
        }


        vbox {
            maxWidth = Double.MAX_VALUE
            parentWidthProperty.addListener { _, _, newValue -> prefWidth = newValue.toDouble() * .5 }

            add(PreviewView())
        }
    }
}