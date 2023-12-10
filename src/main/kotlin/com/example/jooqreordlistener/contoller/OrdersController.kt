package com.example.jooqreordlistener.contoller

import com.example.jooqrecordlistener.driver.jooqRecordListenerDB.enums.OrderStatus
import com.example.jooqreordlistener.repository.OrderRepository
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import kotlin.random.Random

@RestController
class OrdersController(val orderRepository: OrderRepository) {
     @PostMapping("/order/")
     fun createOrder(){
         return orderRepository.insert(Random.nextInt(1, 1000000), "test", OrderStatus.UNAPPROVED)
     }
}