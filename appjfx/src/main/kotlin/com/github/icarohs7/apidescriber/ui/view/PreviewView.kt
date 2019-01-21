package com.github.icarohs7.apidescriber.ui.view

import com.github.icarohs7.apidescriber.data.entities.ApiSpec
import com.github.icarohs7.apidescriber.data.serialize
import com.github.icarohs7.apidescriber.domain.Injector
import com.github.icarohs7.apidescriber.ui.view.baseclasses.ScopedView
import javafx.beans.property.Property
import javafx.scene.layout.Priority
import org.koin.standalone.inject
import tornadofx.*

class PreviewView : ScopedView("Preview") {
    private val spec: Property<ApiSpec> by Injector.inject("ApiSpec")

    override val root = textarea(spec.value.serialize()) {
        spec.onChange { text = it?.serialize().orEmpty() }
        isEditable = false
        vgrow = Priority.ALWAYS
        hgrow = Priority.ALWAYS
    }
}
