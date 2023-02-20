package xyz.dava.mqx.api

interface MessageQueue {
    fun send(message: String)

    fun bindView()

}
