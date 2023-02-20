package xyz.dava.mqx.view.mq

import javafx.collections.FXCollections
import javafx.geometry.Insets
import javafx.geometry.Pos
import tornadofx.*

class ActiveMqView: View("Active") {

    private val host = FXCollections.observableArrayList("127.0.0.1:8080")

    override val root = borderpane {
        padding = Insets(10.0,5.0,10.0,5.0)
        top {
            hbox(10, Pos.CENTER_LEFT) {
                label("主机") {
                    hboxConstraints {
                        marginLeft = 10.0
                    }
                }
                combobox<String> {
                    items = host
                }
            }
        }
    }
}
