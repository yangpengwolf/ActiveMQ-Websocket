package com.myth.MQ;

/**
 * ClassName: WebController
 * Description: <p> 页面访问 </p >
 * Date: 19/4/10 10:35
 *
 * @version 1.0.0
 * @auther: Yangpeng
 * @since JDK 1.8
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.HashMap;

@Controller
@RequestMapping("/web")
public class WebController {


    private static final Logger LOG = LoggerFactory.getLogger(MsgController.class);

    @Autowired
    private WebSocketServer socketServer;

    @RequestMapping("/showmsg")
    public String showmsg(HashMap<String, Object> map) {


        map.put("msg", "Hello Mr.MythMQ! ");
        LOG.info("Hello Mr.MythMQ! ");
        return "showmsg";


    }


    //页面请求
    @GetMapping("/socket/{cid}")
    public ModelAndView socket(@PathVariable String cid) {
        ModelAndView mav = new ModelAndView("/websocket");
        mav.addObject("cid", cid);
        LOG.info("Connect Cid= " + cid);
        return mav;
    }

    //推送数据接口
    @ResponseBody
    @RequestMapping("/socket/push/{cid}")

    public String pushToWeb(@PathVariable String cid, String message) {
        try {
            socketServer.sendInfo("sssss");
        } catch (IOException e) {
            e.printStackTrace();
            return cid + "#" + e.getMessage();
        }
        return cid;
    }
}
