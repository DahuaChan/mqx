package view.mq

import androidx.compose.runtime.Composable
import model.View
import org.jetbrains.jewel.ui.component.Text

@Composable
@View(title = "RocketMQ", position = 5, icon = "icons/rocketmq/icon.svg")
fun RocketMqView() {
    Text("RocketMQ")
}
