import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import org.jetbrains.jewel.foundation.theme.JewelTheme
import org.jetbrains.jewel.intui.standalone.Inter
import org.jetbrains.jewel.intui.standalone.JetBrainsMono
import org.jetbrains.jewel.intui.standalone.theme.*
import org.jetbrains.jewel.intui.window.decoratedWindow
import org.jetbrains.jewel.intui.window.styling.dark
import org.jetbrains.jewel.intui.window.styling.light
import org.jetbrains.jewel.intui.window.styling.lightWithLightHeader
import org.jetbrains.jewel.ui.ComponentStyling
import org.jetbrains.jewel.window.DecoratedWindow
import org.jetbrains.jewel.window.styling.TitleBarStyle
import view.TitleBarView
import viewmodel.MainVM

fun main() = application {
    val textStyle = JewelTheme.createDefaultTextStyle(fontFamily = FontFamily.Inter)
    val editorStyle = JewelTheme.createEditorTextStyle(fontFamily = FontFamily.JetBrainsMono)

    val themeDefinition =
        if (MainVM.theme.isDark()) {
            JewelTheme.darkThemeDefinition(defaultTextStyle = textStyle, editorTextStyle = editorStyle)
        } else {
            JewelTheme.lightThemeDefinition(defaultTextStyle = textStyle, editorTextStyle = editorStyle)
        }
    IntUiTheme(
        theme = themeDefinition,
        styling = ComponentStyling.default().decoratedWindow(
            titleBarStyle =
            when (MainVM.theme) {
                IntUiThemes.Light -> TitleBarStyle.light()
                IntUiThemes.LightWithLightHeader -> TitleBarStyle.lightWithLightHeader()
                IntUiThemes.Dark -> TitleBarStyle.dark()
                IntUiThemes.System ->
                    if (MainVM.theme.isDark()) {
                        TitleBarStyle.dark()
                    } else {
                        TitleBarStyle.light()
                    }
            },
        ),
        swingCompatMode = MainVM.swingCompat
    ) {
        DecoratedWindow(
            title = MainVM.currentView.title,
            state = rememberWindowState(width = 800.dp, height = 600.dp, position = WindowPosition(Alignment.Center)),
            onCloseRequest = ::exitApplication
        ) {
            TitleBarView()
            MainVM.currentView.content()
        }
    }
}
