package com.github.icarohs7.apidescriber.domain.extensions

import javafx.beans.property.Property
import javafx.beans.property.SimpleStringProperty
import tornadofx.*

fun <T> Property<T>.bidirectionalMap(tToStr: (T) -> String, strToT: (String) -> T): Property<String> {
    val prop = SimpleStringProperty(tToStr(this.value))

    this.onChange { newValue ->
        if (newValue != null && newValue != prop.value)
            prop.value = tToStr(newValue)
    }

    prop.onChange { newValue ->
        if (newValue != null && newValue != this.value)
            this.value = strToT(newValue)
    }

    return prop
}