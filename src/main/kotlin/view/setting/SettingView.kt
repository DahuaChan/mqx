package view.setting

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.jetbrains.jewel.foundation.modifier.trackActivation
import org.jetbrains.jewel.foundation.theme.JewelTheme
import org.jetbrains.jewel.ui.component.IconButton
import org.jetbrains.jewel.ui.component.Text
import viewmodel.MainVM

@Composable
fun SettingView() {
    Row(Modifier.trackActivation().fillMaxSize().background(JewelTheme.globalColors.panelBackground)) {
        IconButton({ MainVM.currentView = MainVM.views["AppView"]?: MainVM.views.values.first()}) {
            Text("Back")
        }
    }
}
