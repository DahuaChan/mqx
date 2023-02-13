package xyz.dava.mqx

import xyz.dava.mqx.api.MessageQueue
import xyz.dava.mqx.mq.rabbit.RabbitMessageQueue

fun main(args: Array<String>) {
    val mq:MessageQueue = RabbitMessageQueue()
    mq.send("data")
}
