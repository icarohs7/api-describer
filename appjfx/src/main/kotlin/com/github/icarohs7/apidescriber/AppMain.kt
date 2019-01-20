package com.github.icarohs7.apidescriber

import com.github.icarohs7.apidescriber.data.local.ApiSpecRepository
import com.github.icarohs7.apidescriber.data.local.unaryPlus
import com.github.icarohs7.apidescriber.ui.style.GlobalStyles
import com.github.icarohs7.apidescriber.ui.view.MainView
import org.koin.dsl.module.module
import org.koin.standalone.StandAloneContext.startKoin
import tornadofx.*

class AppMain : App(MainView::class, GlobalStyles::class) {
    init {
        startKoin(getKoinModules())
    }

    private fun getKoinModules() = listOf(module {
        single { +ApiSpecRepository }
    })
}

// TODO localization - extract strings
// Documentation - ApiSpecRepository must be injected by client