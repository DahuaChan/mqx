package xyz.dava.mqx.mq.rabbit.demo

import tornadofx.*

class PersonViewModel : ViewModel() {
    val nameProperty = bind { selectedPerson?.nameProperty }
    val ageProperty = bind { selectedPerson?.ageProperty }

    var selectedPerson: Person? by property(null)

    fun createPerson(name: String, age: Int) {
        val person = Person(name, age)
        persons.add(person)
        selectPerson(person)
    }

    fun selectPerson(person: Person?) {
        selectedPerson = person
    }

    val persons = observableListOf<Person>()
}

