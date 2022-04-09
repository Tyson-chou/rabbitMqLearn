package com.ztc.orderconsumer.consumer.topic;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;



// bindings其实就是用来确定队列和交换机绑定关系
@RabbitListener(bindings = @QueueBinding(
        value = @Queue(value = "sms.topic.queue",durable = "true",autoDelete = "false"),
        exchange = @Exchange(value = "topic_order_exchange",type = ExchangeTypes.TOPIC),
        key = "#.sms.#"
))
@Component
public class SMSServiceTopic {
    // @RabbitHandler 代表此方法是一个消息接收的方法。该不要有返回值
    @RabbitHandler
    public void messagerevice(String message){
        // 此处省略发邮件的逻辑
        System.out.println("sms-------------->" + message);
    }
}