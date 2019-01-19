package com.github.icarohs7.apidescriber.ui.view

import com.github.icarohs7.apidescriber.ui.style.GlobalStyles
import tornadofx.*

class MainView : View("Hello TornadoFX") {
    override val root = hbox {
        label(title) {
            addClass(GlobalStyles.heading)
        }
    }
}