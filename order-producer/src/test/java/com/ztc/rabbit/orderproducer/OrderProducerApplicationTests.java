package com.ztc.rabbit.orderproducer;

import com.ztc.rabbit.orderproducer.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OrderProducerApplicationTests {

    @Autowired
    OrderService orderService;

    @Test
    void contextLoads() throws InterruptedException {


        for (int i = 0; i < 2; i++) {
            Thread.sleep(1000);
            Long userId = 100L + i;
            Long productId = 10001L + i;
            int num = 10;
            orderService.makeOrderDirect(userId, productId, num);
        }
    }

    @Test
    void contextLoadsTopic() throws InterruptedException {


        for (int i = 0; i < 2; i++) {
            Thread.sleep(1000);
            Long userId = 100L + i;
            Long productId = 10001L + i;
            int num = 10;
            orderService.makeOrderTopic(userId, productId, num);
        }
    }


}
