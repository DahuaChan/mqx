package view.mq

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import model.View
import org.jetbrains.jewel.foundation.modifier.trackActivation
import org.jetbrains.jewel.foundation.theme.JewelTheme
import org.jetbrains.jewel.ui.component.Text

@Composable
@View(title = "ActiveMQ", position = 1, icon = "icons/activemq/icon.svg")
fun AmqView() {
    Row() {
        Text("ActiveMQ")
    }
}
