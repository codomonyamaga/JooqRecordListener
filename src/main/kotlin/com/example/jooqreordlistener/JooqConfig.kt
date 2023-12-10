package com.example.jooqreordlistener

import org.jooq.DSLContext
import org.jooq.SQLDialect
import org.jooq.impl.DefaultConfiguration
import org.jooq.impl.DefaultDSLContext
import org.jooq.impl.DefaultRecordListenerProvider
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.sql.DataSource
import org.jooq.Configuration as JooqConfiguration


@Configuration
class JooqConfig {

    @Autowired
    lateinit var dataSource: DataSource

    @Bean
    fun dslContext(configuration:JooqConfiguration): DSLContext {
        return DefaultDSLContext(configuration)
    }

    @Bean
    fun configuration(): JooqConfiguration {
        return DefaultConfiguration()
            .set(SQLDialect.POSTGRES)
            .set(dataSource)
            .set(DefaultRecordListenerProvider(OrdersRecordListener()))
    }
}