package com.github.icarohs7.apidescriber.ui.view

import com.github.icarohs7.apidescriber.ui.view.baseclasses.ScopedView
import javafx.scene.layout.Priority
import tornadofx.*

class PreviewView : ScopedView("Preview") {
    override val root = textarea {
        isEditable = false
        vgrow = Priority.ALWAYS
        hgrow = Priority.ALWAYS
    }
}
