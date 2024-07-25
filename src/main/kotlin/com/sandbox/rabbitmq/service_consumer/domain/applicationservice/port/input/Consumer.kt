package com.sandbox.rabbitmq.service_consumer.domain.applicationservice.port.input

interface Consumer<T>{
    fun consume(event: T)
}