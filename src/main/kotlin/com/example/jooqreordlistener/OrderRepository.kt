package com.example.jooqreordlistener

import com.example.jooqrecordlistener.driver.jooqRecordListenerDB.enums.OrderStatus
import com.example.jooqrecordlistener.driver.jooqRecordListenerDB.tables.records.OrdersRecord
import com.example.jooqrecordlistener.driver.jooqRecordListenerDB.tables.references.ORDERS
import org.jooq.DSLContext
import org.jooq.impl.DSL
import org.springframework.stereotype.Component
import kotlin.random.Random

@Component
class OrderRepository(private val dslContext: DSLContext) {

    fun insert(id: Int, name: String, status: OrderStatus): Unit {
//        dslContext.insertInto(ORDERS)
//            .set(ORDERS.ID, id)
//            .set(ORDERS.NAME, name)
//            .set(ORDERS.STATUS, status)
//            .execute()

        val newOrderRecord = dslContext.newRecord(ORDERS)
        // Populate the record with values
        newOrderRecord.id = Random.nextInt(1000001, 2000000)
        newOrderRecord.name = "test"
        newOrderRecord.status = OrderStatus.UNAPPROVED

        // Insert the populated record into the database
        newOrderRecord.store()
    }

}