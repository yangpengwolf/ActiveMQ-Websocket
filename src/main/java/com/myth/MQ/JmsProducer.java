package com.myth.MQ;

import org.apache.activemq.command.ActiveMQMessage;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import java.util.Map;

@Component
public class JmsProducer {

    private Logger LOG = LoggerFactory.getLogger(JmsProducer.class);

    @Autowired
    @Qualifier("firstJmsTemplate")
    private JmsMessagingTemplate jmsTemplate;

    @Value("${activemq.topic}")
    private String topic;

    @Value("${activemq.queue}")
    private String queue;

    @Value("${activemq.virtual.topic}")
    private String vTopic;

    public void sendMsg(Destination destination, Message msg) {
        jmsTemplate.convertAndSend(destination, msg);
    }

    /**
     * send msg to queue.ØØØ
     * @param data
     */
    public void sendToQueue(Map<String, String> data) {
        ActiveMQQueue mqQueue = new ActiveMQQueue(queue);
        ActiveMQMessage msg = new ActiveMQMessage();
        try {
            LOG.info(data.get("value"));

            msg.setStringProperty("value", data.get("value"));
        } catch (JMSException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        sendMsg(mqQueue, msg);
    }

    /**
     * send msg to topic.
     * @param data
     */
    public void sendToTopic(Map<String, String> data) {
        ActiveMQTopic mqTopic = new ActiveMQTopic(topic);
        ActiveMQMessage msg = new ActiveMQMessage();
        try {

            msg.setStringProperty("value", data.get("value"));
        } catch (JMSException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        sendMsg(mqTopic, msg);
    }
    /**
     * sendmsg to Topic
     *
     */

    /**
     * send msg to virtual topic.
     * @param data
     */
    public void sendToVTopic(Map<String, String> data) {
        ActiveMQTopic mqVTopic = new ActiveMQTopic(vTopic);
        ActiveMQMessage msg = new ActiveMQMessage();
        try {
            msg.setStringProperty("value", data.get("value"));
        } catch (JMSException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        sendMsg(mqVTopic, msg);
    }
}
