package com.myth.MQ;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Date;



@RestController
@RequestMapping("/mqmsg")
public class MsgController {

    private static final Logger LOG = LoggerFactory.getLogger(MsgController.class);
    @Autowired
    private Environment env;

    @Autowired

    private  JmsProducer sender;



    @RequestMapping("/hellomsg")

    public String hello() {
        LOG.info("==========Print log==========");

        return "Hello SpringBoot Msg";
    }

    @RequestMapping("/info")
    public String info() {
        return "Info:" + env.getProperty("url");
    }

    @RequestMapping("/sendmsg")

    public String sendmsg(){
        LOG.info("Send To  Topci");
        Map<String, String> msg = new HashMap<>();
        msg.put("key", "i,activeMQ Topic");
        msg.put("who","yangpeng");
        msg.put("where","886");
        msg.put("when","yangpengwolf@163.com");
        msg.put("event","Eenter");
        msg.put("value", "value:"+String.valueOf(Math.random()*1000));

        sender.sendToTopic(msg);
        return  new Date().toLocaleString() + " Send to Topic Msg OK";

    }






}
