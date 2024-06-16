package view

import StandaloneSampleIcons
import androidx.compose.animation.core.spring
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.jewel.foundation.modifier.trackActivation
import org.jetbrains.jewel.foundation.theme.JewelTheme
import org.jetbrains.jewel.ui.Orientation
import org.jetbrains.jewel.ui.component.Divider
import org.jetbrains.jewel.ui.component.Dropdown
import org.jetbrains.jewel.ui.component.Icon
import org.jetbrains.jewel.ui.component.Text
import org.jetbrains.jewel.ui.painter.hints.Size
import org.jetbrains.jewel.ui.painter.rememberResourcePainterProvider
import viewmodel.mq.MqVM

@Composable
@Preview
fun AppView() {
    Column(Modifier.trackActivation().fillMaxSize().background(JewelTheme.globalColors.panelBackground)) {
        Row(Modifier.fillMaxWidth().padding(3.dp), Arrangement.spacedBy(5.dp)) {
            Dropdown(Modifier.height(30.dp), menuContent =
            {
                MqVM.views.forEach {
                    selectableItem(
                        selected = MqVM.currentView == it,
                        onClick = {
                            MqVM.currentView = it
                        },
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(4.dp),
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            val painterProvider =
                                rememberResourcePainterProvider(it.icon, StandaloneSampleIcons::class.java)
                            val painter by painterProvider.getPainter(Size(20))
                            Icon(painter, "icon", modifier = Modifier.size(20.dp))
                            Text(it.title)
                        }
                    }
                }
            }
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(3.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(4.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        val painterProvider =
                            rememberResourcePainterProvider(
                                MqVM.currentView.icon,
                                StandaloneSampleIcons::class.java,
                            )
                        val painter by painterProvider.getPainter(Size(20))
                        Icon(painter, "icon")
                        Text(MqVM.currentView.title)
                    }
                }
            }
        }
        Divider(Orientation.Horizontal)
        MqVM.currentView.content()
    }
}
