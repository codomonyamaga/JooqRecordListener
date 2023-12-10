package com.example.jooqreordlistener.contoller

import com.example.jooqrecordlistener.driver.jooqRecordListenerDB.enums.OrderStatus
import com.example.jooqreordlistener.repository.ItemRepository
import com.example.jooqreordlistener.repository.OrderRepository
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import kotlin.random.Random

@RestController
class ItemsController(val itemRepository: ItemRepository) {
     @PostMapping("/item/")
     fun saveItem(){
         return itemRepository.insert(Random.nextInt(1, 1000000), "item")
     }
}