package viewmodel.mq

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.toMutableStateList
import reflection.findViews

object MqVM {
    val views = findViews("view.mq").toMutableStateList()
    var currentView by mutableStateOf(views.first())
}
