package cn.com.hohistar.tutorial.springboot.starter.amqp;

import cn.com.hohistar.tutorial.springboot.starter.model.Todo;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Log4j2
@Component
public class Receiver {

    @Autowired
    private MessageConverter messageConverter;


    @PostConstruct
    public void init() {
    }


    @RabbitListener(queues = "hello.queue1")
    public Todo processMessage1(Todo msg) {
        log.debug("{}  接收到来自hello.queue1队列的消息：{}", Thread.currentThread().getName(), msg);
        return msg;
    }

    @RabbitListener(queues = "hello.queue2")
    public void processMessage2(Todo msg) {
        log.debug("{}  接收到来自hello.queue2队列的消息：{} ", Thread.currentThread().getName(), msg);
    }

}