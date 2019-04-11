package com.myth.MQ;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class MqApplication {

	public static void main(String[] args) {
		SpringApplication.run(MqApplication.class, args);

//		SpringApplication springApplication = new SpringApplication(MqApplication.class);
//		ConfigurableApplicationContext configurableApplicationContext = springApplication.run(args);
//		WebSocketController.setApplicationContext(configurableApplicationContext);  // 解决WebSocket不能注入的问题


	}

}

