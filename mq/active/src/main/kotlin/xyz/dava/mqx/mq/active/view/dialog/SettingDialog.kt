package xyz.dava.mqx.mq.active.view.dialog

import javafx.scene.layout.BorderPane
import tornadofx.*
import xyz.dava.mqx.mq.active.controller.dialog.SettingController
import xyz.dava.mqx.mq.active.view.ActiveMqView

class SettingDialog : View(){
    private val controller: SettingController by inject()
    var parent: ActiveMqView by singleAssign()

    override val root = splitpane {
        button("test") {  }
        form {
            fieldset("基本信息") {
                field("Ip:") {
                    textfield(controller.ip)
                }
                field("端口:") {
                    textfield(controller.port)
                }
            }
        }
    }
}
