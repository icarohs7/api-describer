package com.github.icarohs7.apidescriber

import com.github.icarohs7.apidescriber.ui.style.GlobalStyles
import com.github.icarohs7.apidescriber.ui.view.MainView
import tornadofx.App

class AppMain: App(MainView::class, GlobalStyles::class)