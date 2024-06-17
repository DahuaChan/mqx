package view.setting

import StandaloneSampleIcons
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import model.View
import org.jetbrains.jewel.ui.Orientation
import org.jetbrains.jewel.ui.component.*
import viewmodel.setting.SettingVM

@View("Host", position = 1, icon = "icons/setting/host.svg")
@Composable
fun HostConfigView() {
    Column {
        Spacer(Modifier.height(10.dp))
        Row {
            Spacer(Modifier.width(15.dp))
            Text(SettingVM.currentView.title)
        }
        Spacer(Modifier.height(10.dp))
        Divider(Orientation.Horizontal)
        HorizontalSplitLayout(first = { modifier ->
            Column(modifier.fillMaxHeight()) {
                HostToolBar()
                Divider(Orientation.Horizontal)
                Column {
                    Text("Nothing To Show")
                }
            }
        }, second = { modifier ->
            Column(modifier.fillMaxHeight()) {
            }
        }, Modifier.fillMaxSize(), initialDividerPosition = 190.dp)
    }
}

@Composable
fun HostToolBar() {
    Row(
        Modifier.padding(5.dp).height(25.dp).fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(5.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton({}, Modifier.size(20.dp)) {
            Icon("icons/add.svg", "Add", StandaloneSampleIcons::class.java)
        }
        IconButton({}, Modifier.size(20.dp)) {
            Icon("icons/add.svg", "Add", StandaloneSampleIcons::class.java)
        }
        IconButton({}, Modifier.size(20.dp)) {
            Icon("icons/add.svg", "Add", StandaloneSampleIcons::class.java)
        }
    }
}
