package cn.com.hohistar.tutorial.springboot.starter.amqp;

import cn.com.hohistar.tutorial.springboot.starter.model.Todo;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.UUID;

@Log4j2
@Component
public class Sender implements RabbitTemplate.ConfirmCallback, RabbitTemplate.ReturnCallback {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private MessageConverter messageConverter;

    @PostConstruct
    public void init() {
        rabbitTemplate.setConfirmCallback(this);
        rabbitTemplate.setReturnCallback(this);
        rabbitTemplate.setMessageConverter(messageConverter);
    }

    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        if (ack) {
            log.debug("消息发送成功: {}", correlationData);
        } else {
            log.debug("消息发送失败: {}", cause);
        }

    }

    @Override
    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
        log.debug("{} 发送失败", message.getMessageProperties().getCorrelationId().toString());

    }

    //发送消息，不需要实现任何接口，供外部调用。
    public void send(Todo todo){

        CorrelationData correlationId = new CorrelationData(UUID.randomUUID().toString());

        log.debug("开始发送消息 : {}", todo);

        rabbitTemplate.convertSendAndReceive("topicExchange", "key.1", todo, correlationId);

        log.debug("结束发送消息 : {}", todo);
        log.debug("消费者响应 : {}  消息处理完成");
    }

}