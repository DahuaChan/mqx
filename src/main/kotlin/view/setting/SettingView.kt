package view.setting

import StandaloneSampleIcons
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.jewel.foundation.modifier.trackActivation
import org.jetbrains.jewel.foundation.theme.JewelTheme
import org.jetbrains.jewel.ui.Orientation
import org.jetbrains.jewel.ui.component.*
import org.jetbrains.jewel.ui.component.styling.LocalIconButtonStyle
import org.jetbrains.jewel.ui.component.styling.TooltipMetrics
import org.jetbrains.jewel.ui.component.styling.TooltipStyle
import org.jetbrains.jewel.ui.painter.hints.Size
import org.jetbrains.jewel.ui.painter.hints.Stroke
import org.jetbrains.jewel.ui.painter.rememberResourcePainterProvider
import org.jetbrains.jewel.ui.theme.tooltipStyle
import viewmodel.MainVM
import viewmodel.mq.MqVM
import viewmodel.setting.SettingVM
import kotlin.time.Duration.Companion.milliseconds

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SettingView() {
    Row(Modifier.trackActivation().fillMaxSize().background(JewelTheme.globalColors.panelBackground)) {
        Column(
            Modifier.fillMaxHeight().defaultMinSize(minWidth = 200.dp).weight(1F),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column(Modifier.fillMaxWidth().verticalScroll(rememberScrollState())) {
                SettingVM.views.forEach {
                    Tooltip(
                        tooltip = {
                            Text("About ${it.title} Config")
                        }, style =
                        TooltipStyle(
                            JewelTheme.tooltipStyle.colors,
                            TooltipMetrics.defaults(showDelay = 150.milliseconds),
                        ),
                        tooltipPlacement = TooltipPlacement.ComponentRect(Alignment.CenterEnd, Alignment.CenterEnd)
                    ) {
                        SelectableIconButton(
                            selected = SettingVM.currentView == it,
                            onClick = { SettingVM.currentView = it },
                            modifier = Modifier.height(40.dp).padding(5.dp, 5.dp, 5.dp, 0.dp),
                        ) { state ->
                            val tint by LocalIconButtonStyle.current.colors.foregroundFor(state)
                            val painterProvider =
                                rememberResourcePainterProvider(it.icon, StandaloneSampleIcons::class.java)
                            val painter by painterProvider.getPainter(Size(20), Stroke(tint))
                            Row(
                                Modifier.fillMaxWidth().padding(5.dp),
                                horizontalArrangement = Arrangement.spacedBy(5.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(painter = painter, "icon")
                                Text(it.title)
                            }
                        }
                    }
                }
            }
            Column {
                Divider(Orientation.Horizontal)
                IconButton({ MainVM.currentView = MainVM.MQ_VIEW }, Modifier.height(40.dp).fillMaxWidth()) {
                    Icon("icons/back.svg", "back", StandaloneSampleIcons::class.java)
                }
            }
        }
        Divider(Orientation.Vertical)
        Box(Modifier.fillMaxHeight().weight(4F)) {
            SettingVM.currentView.content()
        }
    }
}
