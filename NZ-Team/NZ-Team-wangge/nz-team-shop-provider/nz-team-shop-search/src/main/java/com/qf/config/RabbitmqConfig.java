package com.qf.config;

import com.qf.constant.RabbitConstant;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitmqConfig {

    @Bean
    public Queue getQueue(){
        return new Queue(RabbitConstant.PRODUCT_ADD_TO_SEARCH_QUEUE);
    }

    //topic
    @Bean
    public TopicExchange getTopicExchange(){
        return new TopicExchange(RabbitConstant.PRODUCT_ADD_TOPIC_EXCHANGE);
    }

    //设置队列和交换机的绑定关系
    @Bean
    public Binding getBinding(Queue queue, TopicExchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with("product.add");
    }



}
