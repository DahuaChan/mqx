package view.setting

import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import model.View
import org.jetbrains.jewel.ui.component.Text

@View("Host2", position = 2, icon = "icons/setting/host.svg")
@Composable
fun HostConfigView2(){
    Row {
        Text("2")
    }
}
