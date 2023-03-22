package xyz.dava.mqx.mq.active.controller.dialog

import javafx.beans.property.SimpleIntegerProperty
import javafx.beans.property.SimpleStringProperty
import tornadofx.*

class SettingController: Controller() {
    var ip = SimpleStringProperty()
    var port = SimpleIntegerProperty()
}
