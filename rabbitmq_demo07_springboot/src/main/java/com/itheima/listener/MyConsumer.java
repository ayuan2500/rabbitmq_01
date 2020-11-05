package com.itheima.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/***
 * @ClassName MyConsumer
 * @Description 消息监听处理类
 * @version 1.0.0
 * @author ayuan
 * @createTime 2020/11/05 16:17:00
 */
@Component  //将该类交给Spring容器作为消息监听处理类
public class MyConsumer {
    //监听某一个队列 由修饰了该注解的方法来执行接收消息的业务逻辑
    @RabbitListener(queues="queue_springboot")
    public void jieshouMessage(String message){
        System.out.println(message);
    }
}
