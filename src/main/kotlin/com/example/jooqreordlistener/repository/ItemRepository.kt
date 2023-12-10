package com.example.jooqreordlistener.repository

import com.example.jooqrecordlistener.driver.jooqRecordListenerDB.tables.references.ITEMS
import org.jooq.DSLContext
import org.springframework.stereotype.Component
import kotlin.random.Random

@Component
class ItemRepository(private val dslContext: DSLContext) {

    fun insert(id: Int, name: String): Unit {
        val newOrderRecord = dslContext.newRecord(ITEMS)
        // Populate the record with values
        newOrderRecord.id = Random.nextInt(1000001, 2000000)
        newOrderRecord.name = "test"

        // Insert the populated record into the database
        newOrderRecord.store()
    }

}