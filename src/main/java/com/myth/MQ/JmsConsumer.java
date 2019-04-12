package com.myth.MQ;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;
import java.io.IOException;

@Component
public class JmsConsumer {

    @Autowired
    private WebSocketServer webSocketServer;

    private Logger logger = LoggerFactory.getLogger(JmsConsumer.class);

    @JmsListener(destination = "${activemq.topic}", containerFactory = "firstTopicListener")
    @Async // receive msg asynchronously
    //@Async("taskExecutePool")

    public void receiveTopic(Message msg) throws JMSException,NullPointerException {
        TextMessage msgt= (TextMessage)msg;

        logger.info(Thread.currentThread().getName() + ": topic===========" +   msgt.getText());
        try {
            Thread.sleep(2000L);
            webSocketServer.sendInfo( msgt.getText());
            //logger.info(msg.toString());
            // msg.acknowledge(); //消息确认
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }catch (IOException e)
        {e.printStackTrace();}
        logger.debug(Thread.currentThread().getName() + ": topic===========" + msg.getStringProperty("value"));
    }

    @JmsListener(destination = "${activemq.queue}", containerFactory = "firstQueueListener")
    @Async
    public void receiveQueue(Message msg) throws JMSException {
        logger.debug(Thread.currentThread().getName() + ": Queue===========" + msg.getStringProperty("value"));
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        logger.debug(Thread.currentThread().getName() + ": Queue===========" + msg.getStringProperty("value"));
    }

    @JmsListener(destination = "${activemq.virtual.topic.A}", containerFactory = "firstQueueListener")
    @Async
    public void receiveVTopicA1(Message msg) throws JMSException {
        logger.debug(Thread.currentThread().getName() + ": vtopic A1===========" + msg.getStringProperty("value"));
        try {

            Thread.sleep(1000L);
            //webSocketServer.sendInfo(  msg.getText());
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        logger.debug(Thread.currentThread().getName() + ": vtopic A1===========" + msg.getStringProperty("value"));
    }

    @JmsListener(destination = "${activemq.virtual.topic.A}", containerFactory = "firstQueueListener")
    @Async
    public void receiveVTopicA2(Message msg) throws JMSException {
        logger.debug(Thread.currentThread().getName() + ": vtopic A2===========" + msg.getStringProperty("value"));
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        logger.debug(Thread.currentThread().getName() + ": vtopic A2===========" + msg.getStringProperty("value"));
    }

    @JmsListener(destination = "${activemq.virtual.topic.B}", containerFactory = "firstQueueListener")
    @Async
    public void receiveVTopicB(Message msg) throws JMSException {
        logger.debug(Thread.currentThread().getName() + ": vtopic B===========" + msg.getStringProperty("value"));
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        logger.debug(Thread.currentThread().getName() + ": vtopic B===========" + msg.getStringProperty("value"));
    }
}
