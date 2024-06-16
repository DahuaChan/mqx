package view.mq

import androidx.compose.runtime.Composable
import model.View
import org.jetbrains.jewel.ui.component.Text

@Composable
@View(title = "Kafka", position = 3, icon = "icons/kafka/icon.svg")
fun KafkaView() {
    Text("Kafka")
}
