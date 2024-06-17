package view

import IntUiThemes
import StandaloneSampleIcons
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.jewel.ui.component.Icon
import org.jetbrains.jewel.ui.component.IconButton
import org.jetbrains.jewel.ui.component.Text
import org.jetbrains.jewel.ui.component.Tooltip
import org.jetbrains.jewel.window.DecoratedWindowScope
import org.jetbrains.jewel.window.TitleBar
import org.jetbrains.jewel.window.newFullscreenControls
import viewmodel.MainVM

@OptIn(ExperimentalFoundationApi::class)
@Preview
@Composable
fun DecoratedWindowScope.TitleBarView() {
    TitleBar(Modifier.newFullscreenControls(), gradientStartColor = MainVM.projectColor) {
        Text(title)

        Row(Modifier.align(Alignment.End)) {
            Tooltip({ Text("Open Setting Dialog") }) {
                IconButton({
                    MainVM.currentView = MainVM.SETTING_VIEW
                }, Modifier.size(40.dp).padding(5.dp)) {
                    Icon(
                        "icons/settings.svg",
                        "Settings",
                        StandaloneSampleIcons::class.java
                    )
                }
            }
            Tooltip({
                when (MainVM.theme) {
                    IntUiThemes.Light -> Text("Switch to light theme with light header")
                    IntUiThemes.LightWithLightHeader -> Text("Switch to dark theme")
                    IntUiThemes.Dark, IntUiThemes.System -> Text("Switch to light theme")
                }
            }) {
                IconButton({
                    MainVM.theme =
                        when (MainVM.theme) {
                            IntUiThemes.Light -> IntUiThemes.LightWithLightHeader
                            IntUiThemes.LightWithLightHeader -> IntUiThemes.Dark
                            IntUiThemes.Dark, IntUiThemes.System -> IntUiThemes.Light
                        }
                }, Modifier.size(40.dp).padding(5.dp)) {
                    when (MainVM.theme) {
                        IntUiThemes.Light ->
                            Icon(
                                "icons/lightTheme@20x20.svg",
                                "Themes",
                                StandaloneSampleIcons::class.java,
                            )

                        IntUiThemes.LightWithLightHeader ->
                            Icon(
                                "icons/lightWithLightHeaderTheme@20x20.svg",
                                "Themes",
                                StandaloneSampleIcons::class.java,
                            )

                        IntUiThemes.Dark ->
                            Icon(
                                "icons/darkTheme@20x20.svg",
                                "Themes",
                                StandaloneSampleIcons::class.java,
                            )

                        IntUiThemes.System ->
                            Icon(
                                "icons/systemTheme@20x20.svg",
                                "Themes",
                                StandaloneSampleIcons::class.java,
                            )
                    }
                }
            }
        }
    }
}
