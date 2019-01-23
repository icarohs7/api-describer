package com.github.icarohs7.apidescriber.domain

import com.github.icarohs7.apidescriber.data.entities.ApiSpec
import com.github.icarohs7.apidescriber.data.local.ApiSpecRepository
import javafx.beans.property.Property

typealias Ext<T> = T.() -> Unit
typealias Ext1<T, A> = T.(A) -> Unit
typealias JfxApiSpecRepository = ApiSpecRepository<Property<ApiSpec>>