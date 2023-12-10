package com.example.jooqreordlistener

import org.jooq.RecordListenerProvider
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean


@SpringBootApplication
class JooqReordListenerApplication{
    @Bean
    fun recordListenerProvider(): RecordListenerProvider {
        return RecordListenerProvider { OrdersRecordListener() }
    }
}

fun main(args: Array<String>) {
    runApplication<JooqReordListenerApplication>(*args)
}
