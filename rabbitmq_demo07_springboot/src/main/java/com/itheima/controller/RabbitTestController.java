package com.itheima.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/***
 * @ClassName RabbitMqApplication
 * @Description controller
 * @version 1.0.0
 * @author ayuan
 * @createTime 2020/11/05 16:17:00
 */
@RestController
@RequestMapping("/test")
public class RabbitTestController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    //发送消息
    @RequestMapping("/send")
    public String send(){
        //1.下单
        System.out.println("===========下单成功=====");
        //2.发送消息成功 使用topic模式
        //参数1 指定交换机名称
        //参数2 指定routingkey 的值
        //参数3 指定消息本身
        rabbitTemplate.convertAndSend("exchange_topic_springboot","item.add","哈哈哈赶紧去添加一个商品");
        //3.返回OK
        return "ok";
    }
}
