package com.github.icarohs7.apidescriber.ui.view

import com.github.icarohs7.apidescriber.data.serialize
import com.github.icarohs7.apidescriber.domain.Injector
import com.github.icarohs7.apidescriber.domain.JfxApiSpecRepository
import com.github.icarohs7.apidescriber.ui.view.baseclasses.ScopedView
import javafx.scene.layout.Priority
import org.koin.standalone.inject
import tornadofx.*

class PreviewView : ScopedView("Preview") {
    private val apiSpecRepository: JfxApiSpecRepository by Injector.inject()

    override val root = textarea {
        apiSpecRepository.observable.onChange { text = it?.serialize().orEmpty() }
        isEditable = false
        vgrow = Priority.ALWAYS
        hgrow = Priority.ALWAYS
    }
}
