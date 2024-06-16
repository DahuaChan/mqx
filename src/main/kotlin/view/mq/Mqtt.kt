package view.mq

import androidx.compose.runtime.Composable
import model.View
import org.jetbrains.jewel.ui.component.Text

@Composable
@View(title = "MQTT", position = 4, icon = "icons/mqtt/icon.svg")
fun MqttView() {
    Text("MQTT")
}
