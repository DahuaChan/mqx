package xyz.dava.mqx

import atlantafx.base.theme.PrimerDark
import javafx.stage.Stage
import tornadofx.App
import tornadofx.launch
import xyz.dava.mqx.view.AppRootView


class MqxApp: App(AppRootView::class) {
    override fun start(stage: Stage) {
        // 设置主题
        setUserAgentStylesheet(PrimerDark().userAgentStylesheet)
        // 调用父类启动
        super.start(stage)
    }
}

fun main(args: Array<String>) {
    launch<MqxApp>(args)
}
