package view.mq

import androidx.compose.runtime.Composable
import model.View
import org.jetbrains.jewel.ui.component.Text

@Composable
@View(title = "RabbitMQ", position = 2, icon = "icons/rabbitmq/icon.svg")
fun RmqView() {
    Text("RabbitMQ")
}
