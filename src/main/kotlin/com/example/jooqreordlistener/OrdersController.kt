package com.example.jooqreordlistener

import com.example.jooqrecordlistener.driver.jooqRecordListenerDB.enums.OrderStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import kotlin.random.Random

@RestController
class OrdersController(val orderRepository: OrderRepository) {
     @PostMapping("/orders/")
     fun getOrder(){
         return orderRepository.insert(Random.nextInt(1, 1000000), "test", OrderStatus.UNAPPROVED)
     }
}