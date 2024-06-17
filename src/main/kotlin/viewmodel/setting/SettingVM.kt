package viewmodel.setting

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.toMutableStateList
import reflection.findViews

object SettingVM {
    val views = findViews("view.setting").toMutableStateList()
    var currentView by mutableStateOf(views.first())
}
