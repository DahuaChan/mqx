package xyz.dava.mqx

import com.github.mouse0w0.darculafx.DarculaFX
import javafx.stage.Stage
import tornadofx.*
import xyz.dava.mqx.view.AppRootView


class MqxApp: App(AppRootView::class) {
    override fun start(stage: Stage) {
        // 设置主题
        FX.stylesheets.add(DarculaFX.DARCULA_STYLE_URL)
        // 调用父类启动
        super.start(stage)
    }
}

fun main(args: Array<String>) {
    launch<MqxApp>(args)
}
