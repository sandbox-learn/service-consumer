package com.sandbox.rabbitmq.service_consumer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ServiceConsumerApplication

fun main(args: Array<String>) {
	runApplication<ServiceConsumerApplication>(*args)
}
