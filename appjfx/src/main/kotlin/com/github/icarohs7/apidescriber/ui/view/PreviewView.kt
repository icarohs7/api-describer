package com.github.icarohs7.apidescriber.ui.view

import com.github.icarohs7.apidescriber.data.local.ApiSpecRepository
import com.github.icarohs7.apidescriber.data.serialize
import com.github.icarohs7.apidescriber.domain.Injector
import javafx.scene.control.TextInputControl
import kotlinx.coroutines.launch
import org.koin.standalone.inject
import tornadofx.*

class PreviewView : ScopedView("Preview") {
    private val apiSpecRepository: ApiSpecRepository by Injector.inject()

    override val root = textarea {
        launch { observeApiSpecChannel() }
        isEditable = false
    }

    private suspend fun TextInputControl.observeApiSpecChannel() {
        for (apiSpec in apiSpecRepository.channel) {
            this.text = apiSpec.serialize()
        }
    }
}
