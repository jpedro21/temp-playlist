package com.app.tempplaylist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class TempPlaylistEurekaServerApplication {

	public static void main(String[] args) {

		SpringApplication.run(TempPlaylistEurekaServerApplication.class, args);
	}

}
