package com.itheima;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/***
 * @ClassName RabbitMqApplication
 * @Description 启动类
 * @version 1.0.0
 * @author ayuan
 * @createTime 2020/11/05 16:17:00
 */
@SpringBootApplication
public class RabbitMqApplication {
    public static void main(String[] args) {
        SpringApplication.run(RabbitMqApplication.class,args);
    }
    //创建队列
    @Bean
    public Queue createQueue(){
        return new Queue("queue_springboot");
    }

    //创建交换机（主题模式）
    @Bean
    public TopicExchange createExchange(){
        return new TopicExchange("exchange_topic_springboot");
    }

    /*
     * 队列和交换机绑定（使用主题模式）
     *  参数1：创建队列的方法
     *  参数2：创建交换机的方法
     *  参数3：RoutingKey
     */
    @Bean
    public Binding createBinding(){
        return BindingBuilder.bind(createQueue()).to(createExchange()).with("item.#");
    }
}
