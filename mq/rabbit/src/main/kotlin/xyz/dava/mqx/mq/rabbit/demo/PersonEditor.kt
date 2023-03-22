package xyz.dava.mqx.mq.rabbit.demo

import tornadofx.*

class PersonEditor : View() {
    val model = PersonViewModel()

    override val root = hbox {
        form {
            fieldset {
                field("Name") {
                    textfield(model.nameProperty)
                }
                field("Age") {
                    textfield(model.ageProperty)
                }
            }
            button("Save") {
                enableWhen(model.nameProperty.isNotEmpty.and(model.ageProperty.isNotEqualTo(-1)))
                action {
                    model.selectedPerson?.let { person ->
                        person.setName(model.nameProperty.value)
                        person.setAge(model.ageProperty.value)
                    } ?: model.createPerson(model.nameProperty.value, model.ageProperty.value)
                }
            }
        }
        tableview(model.persons) {
            column("Name" , Person::getName)
            column("Age", Person::getAge)
            selectionModel.selectedItemProperty().addListener { _, _, newValue ->
                model.selectPerson(newValue)
            }
        }
    }
}

