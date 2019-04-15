package com.myth.MQ;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;


/**
 * ClassName: MsgEntity
 * Description: <p> 消息定义 </p >
 * Date: 19/4/12 20:28
 *
 * @version 1.0.0
 * @auther: Yangpeng
 * @since JDK 1.8
 */

//
//@Entity
//@Table(name = "t_app_msg")
public class MsgEntity implements Serializable {

    private static final long serialVersionUID = -3258839839160856613L;

    private  String SystemId ;

    @JsonFormat( pattern="yyyy-MM-dd HH:mm:ss")
    private Date msgwhen;

    private  String msgwhere;
    private  String msgwho;
    private String  msgwhat;




}
