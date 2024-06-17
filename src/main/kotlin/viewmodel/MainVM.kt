package viewmodel

import IntUiThemes
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import model.ViewInfo
import view.mq.MqView
import view.setting.SettingView

object MainVM {
    var theme: IntUiThemes by mutableStateOf(IntUiThemes.Dark)

    var swingCompat: Boolean by mutableStateOf(false)

    val projectColor
        get() =
            if (theme.isLightHeader()) {
                Color(0xFFF5D4C1)
            } else {
                Color(0xFF654B40)
            }
    val MQ_VIEW = ViewInfo("MQX", 0, "icons/logo.svg") { MqView() }
    val SETTING_VIEW = ViewInfo("Settings", 1, "icons/settings.svg") { SettingView() }
    var currentView by mutableStateOf(SETTING_VIEW)
}
