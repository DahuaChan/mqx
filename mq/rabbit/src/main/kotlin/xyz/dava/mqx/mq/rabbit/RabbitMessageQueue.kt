package xyz.dava.mqx.mq.rabbit

import xyz.dava.mqx.api.MessageQueue

class RabbitMessageQueue: MessageQueue {
    override fun send(message: String) {
        println(message)
    }

    override fun bindView() {
        TODO("Not yet implemented")
    }
}
