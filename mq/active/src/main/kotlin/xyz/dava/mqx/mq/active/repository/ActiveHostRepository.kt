package xyz.dava.mqx.mq.active.repository

import xyz.dava.mqx.api.model.MqServerInfo

class ActiveHostRepository {

    companion object {
        val repository = ActiveHostRepository()
    }

    fun findAll(): List<MqServerInfo> {
        val data: MutableList<MqServerInfo> = ArrayList()
        data.add(MqServerInfo("127.0.0.1", 8080, "tcp", HashMap()))
        data.add(MqServerInfo("127.0.0.1", 8081, "tcp", HashMap()))
        return data
    }
}
