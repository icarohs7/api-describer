package com.github.icarohs7.apidescriber

import com.github.icarohs7.apidescriber.data.entities.ApiSpec
import com.github.icarohs7.apidescriber.data.entities.EndpointSpec
import com.github.icarohs7.apidescriber.ui.style.GlobalStyles
import com.github.icarohs7.apidescriber.ui.view.MainView
import javafx.beans.property.Property
import javafx.beans.property.SimpleObjectProperty
import org.koin.dsl.module.module
import org.koin.standalone.StandAloneContext.startKoin
import tornadofx.*

class AppMain : App(MainView::class, GlobalStyles::class) {

    init {
        startKoin(getKoinModules())
    }

    private fun getKoinModules() = listOf(module {
        single<Property<ApiSpec>>("ApiSpec") { SimpleObjectProperty(ApiSpec()) }
        single<Property<EndpointSpec>>("EndpointSpec") { SimpleObjectProperty(EndpointSpec()) }
    })
}

// TODO localization - extract strings
// Documentation - ApiSpecRepository must be injected by client