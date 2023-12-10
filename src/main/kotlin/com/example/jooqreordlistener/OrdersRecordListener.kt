package com.example.jooqreordlistener

import com.example.jooqrecordlistener.driver.jooqRecordListenerDB.tables.references.ORDERS
import org.jooq.*

class OrdersRecordListener : RecordListener {

    // Replace YOUR_TABLE_NAME with the actual name of the table you're interested in
    private val targetTable: Table<*> = ORDERS

    override fun storeEnd(ctx: RecordContext) {
        // このメソッドは、レコードが保存（挿入/更新）された後に呼び出されます。
        if (ctx.recordType() == targetTable.recordType()) {
            println("Ordered: ${ctx.record()}")
        }
    }
}

class OrdersExecuteListener : ExecuteListener {

    override fun executeEnd(ctx: ExecuteContext) {
        println(ctx.statement())
        println(ctx.statementExecutionCount())
    }
}