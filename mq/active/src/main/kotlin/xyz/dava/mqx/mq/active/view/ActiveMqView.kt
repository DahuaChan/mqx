package xyz.dava.mqx.mq.active.view

import com.starsone.icontext.icontext
import javafx.beans.property.SimpleStringProperty
import javafx.collections.FXCollections
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.control.SelectionMode
import javafx.scene.layout.Priority
import javafx.scene.paint.Color
import tornadofx.*
import xyz.dava.mqx.mq.active.view.dialog.SettingDialog

class ActiveMqView : View("Active") {

    private val iconColor = Color.rgb(0xC9, 0xD1, 0xD9)
    private val host = FXCollections.observableArrayList("127.0.0.1:8080")
    private val queueMessage = mutableListOf<String>().asObservable()
    private val selectedMessage = SimpleStringProperty()
    private val settingDialog :SettingDialog by inject()


    override val root = borderpane {
        paddingAll = 5.0
        top {
            vbox(10, Pos.CENTER) {
                hbox(10, Pos.CENTER_LEFT) {
                    label("主机:") {
                        prefWidth = 45.0
                        hboxConstraints {
                            marginLeft = 10.0
                        }
                    }
                    combobox<String>(null, host) {
                        prefWidth = 200.0
                    }
                    button(graphic = icontext("cog") { fill = iconColor }) {
                        tooltip("修改连接信息")
                        action {
                            settingDialog.openModal()
                        }
                    }
                }
                hbox(10, Pos.CENTER_LEFT) {
                    label("Topic:") {
                        prefWidth = 45.0
                        hboxConstraints {
                            marginLeft = 10.0
                        }
                    }
                    textfield {
                        prefWidth = 200.0
                    }
                    button("监听") {
                        action {
                            queueMessage.add("test")
                        }
                    }
                    button("停止")
                }
            }
        }
        center {
            vbox(5) {
                paddingTop = 5
                splitpane() {
                    setDividerPositions(0.5, 0.5)
                    listview(queueMessage) {
                        selectionModel.selectionMode = SelectionMode.SINGLE
                        bindSelected(selectedMessage)
                    }
                    textarea {
                        isEditable = true
                    }
                }
                hbox {
                    prefHeight(50.0)
                    alignment = Pos.CENTER_RIGHT
                    button("发送")
                }
            }
        }
        bottom {
            prefHeight = 300.0
            vbox(5) {
                paddingTop = 5
                hbox(5) {
                    //
                    button {
                        graphic = icontext("cog") {
                            fill = iconColor
                            tooltip("格式化JSON")
                        }
                    }
                }
                textarea(selectedMessage)
            }
        }
    }
}
