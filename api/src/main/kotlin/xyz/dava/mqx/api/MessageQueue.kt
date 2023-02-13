package xyz.dava.mqx.api

public interface MessageQueue {
    fun send(message: String)

    fun bindView()

}
