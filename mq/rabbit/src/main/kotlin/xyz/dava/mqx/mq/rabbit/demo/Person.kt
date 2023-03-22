package xyz.dava.mqx.mq.rabbit.demo

import javafx.beans.property.SimpleIntegerProperty
import javafx.beans.property.SimpleStringProperty

class Person(name: String, age: Int) {
    var nameProperty = SimpleStringProperty(name)
    var ageProperty = SimpleIntegerProperty(age)

    fun getName(): String = nameProperty.value
    fun setName(name: String) = nameProperty.setValue(name)

    fun getAge(): Int = ageProperty.value
    fun setAge(age: Int) = ageProperty.setValue(age)
}

