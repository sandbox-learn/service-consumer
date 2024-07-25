package com.sandbox.rabbitmq.service_consumer.config

import org.springframework.amqp.core.*
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class MessagingConfig {
    @Bean
    fun autoDeleteQueue(): Queue {
        return AnonymousQueue()
    }

    @Bean
    fun fanout(): FanoutExchange {
        return FanoutExchange("sandbox.fanout")
    }

    @Bean
    fun binding(
        fanout: FanoutExchange,
        autoDeleteQueue: Queue?
    ): Binding {
        return BindingBuilder.bind(autoDeleteQueue).to(fanout)
    }
}