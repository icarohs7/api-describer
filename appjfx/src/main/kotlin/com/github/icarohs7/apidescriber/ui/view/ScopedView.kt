package com.github.icarohs7.apidescriber.ui.view

import javafx.scene.Node
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import tornadofx.*

abstract class ScopedView(title: String = "", icon: Node? = null) : View(title, icon), CoroutineScope by MainScope() {
    override fun onDelete() {
        this.cancel()
        super.onDelete()
    }
}