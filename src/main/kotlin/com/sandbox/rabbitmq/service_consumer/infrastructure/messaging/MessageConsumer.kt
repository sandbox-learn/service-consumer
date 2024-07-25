package com.sandbox.rabbitmq.service_consumer.infrastructure.messaging

import com.sandbox.rabbitmq.service_consumer.domain.applicationservice.port.input.Consumer
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Component
import org.springframework.util.StopWatch

@Component
class MessageConsumer() : Consumer<String> {

    @RabbitListener(queues = ["#{autoDeleteQueue.name}"])
    override fun consume(event: String) {
        val watch = StopWatch()
        watch.start()
        println("Handling message: $event")
        handle(event)
        watch.stop()
        println("[x] Done in ${watch.totalTimeSeconds} s")
    }

    private fun handle(message: String) {
        println("processing event: $message")
    }
}