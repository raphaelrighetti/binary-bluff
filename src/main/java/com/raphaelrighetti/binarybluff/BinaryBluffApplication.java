package com.raphaelrighetti.binarybluff;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class BinaryBluffApplication {

	public static void main(String[] args) {
		SpringApplication.run(BinaryBluffApplication.class, args);
	}

}
