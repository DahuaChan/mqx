package xyz.dava.mqx.view

import com.starsone.icontext.view.MainView
import javafx.geometry.Pos
import javafx.scene.control.TabPane
import javafx.scene.layout.Priority
import tornadofx.*
import xyz.dava.mqx.view.mq.ActiveMqView
import xyz.dava.mqx.view.mq.RabbitMqView

/**
 * 应用程序根视图
 * @author dava
 * @date 2023/02/20
 * @constructor 创建[AppRootView]
 */
class AppRootView : View() {

    override val root =
        stackpane {
            setPrefSize(800.0, 600.0)
            tabpane {
                tabClosingPolicy = TabPane.TabClosingPolicy.UNAVAILABLE
                tab<ActiveMqView>()
                tab<RabbitMqView>()
            }
            label("Designed By Dava") {
                stackpaneConstraints {
                    alignment = Pos.TOP_RIGHT
                    marginRight = 10.0
                    marginTop = 10.0
                    hgrow = Priority.ALWAYS
                }
            }
        }
}
