package xyz.dava.mqx.mq.active.view.dialog

import javafx.beans.property.SimpleIntegerProperty
import javafx.beans.property.SimpleStringProperty
import javafx.scene.control.ListView
import tornadofx.*
import xyz.dava.mqx.api.model.MqServerInfo
import xyz.dava.mqx.mq.active.repository.ActiveHostRepository
import xyz.dava.mqx.mq.active.view.ActiveMqView

class SettingDialog : View() {
    private val model = SettingViewModel
    private var parent: ActiveMqView by singleAssign()

    override val root = splitpane {
        setDividerPositions(0.3, 0.7)
        var leftListView: ListView<MqServerInfo>? = null

        listview(model.mqServerInfos) {
            leftListView = this
            cellFormat {
                text = "${it.protocol}://${it.ip}:${it.port}"
            }
            selectionModel.selectedItemProperty().addListener { _, _, newValue ->
                model.selectServer(newValue)
            }
        }
        form {
            fieldset("基本信息") {
                field("Ip:") {
                    textfield(model.selectedIp)
                }
                field("端口:") {
                    textfield(model.selectedPort)
                }
            }
            button("保存") {
                enableWhen(model.selectedIp.isNotEmpty.and(model.selectedPort.isNotEqualTo(-1)))
                action {
                    model.selected?.let { server ->
                        server.ip = model.selectedIp.value
                        server.port = model.selectedPort.value
                        leftListView?.refresh()
                    } ?: model.createServer(model.selectedIp.value, model.selectedPort.value)
                }
            }
        }
    }

    object SettingViewModel : ViewModel() {

        val mqServerInfos = observableListOf<MqServerInfo>()
        var selected: MqServerInfo? by property(null)
        val selectedIp = bind { SimpleStringProperty("127.0.0.1") }
        val selectedPort = bind { SimpleIntegerProperty(0) }

        init {
            mqServerInfos.addAll(ActiveHostRepository.repository.findAll())
        }

        fun createServer(ip: String, port: Int) {
            val server = MqServerInfo(ip, port, "", mapOf())
            mqServerInfos.add(server)
            selectServer(server)
        }

        fun selectServer(server: MqServerInfo?) {
            selected = server
            server?.let {
                selectedIp.value = server.ip
                selectedPort.value = server.port
            }
        }


    }
}

