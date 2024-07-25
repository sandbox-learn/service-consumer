package com.sandbox.rabbitmq.service_consumer.infrastructure.messaging

import com.sandbox.rabbitmq.service_consumer.domain.applicationservice.port.input.Consumer
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Component
import org.springframework.util.StopWatch
import java.time.LocalDateTime

@Component
class MessageConsumer() : Consumer<MessageEvent> {

    @RabbitListener(queues = ["#{autoDeleteQueue.name}"])
    override fun consume(event: MessageEvent) {
        val watch = StopWatch()
        watch.start()
        println("Handling event: $event")
        handle(event)
        watch.stop()
        println("[x] Done in ${watch.totalTimeSeconds} s")
    }

    private fun handle(event: MessageEvent) {
        println("processing event: $event")
        println("The message of event is : ${event.message.value}")
    }
}
data class MessageEvent(
    val message: Message,
    val createdAt: LocalDateTime = LocalDateTime.now(),
)
data class Message(val value: String)

