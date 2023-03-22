package xyz.dava.mqx.mq.rabbit.view

import javafx.collections.FXCollections
import tornadofx.*

class RabbitMqView: View("Rabbit") {

    private val host = FXCollections.observableArrayList("127.0.0.1:8080")

    override val root = borderpane {
        top {
            hbox {
                label("主机")
                combobox<String> {
                    items = host
                }
            }
        }
    }
}
