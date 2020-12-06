package gg.sparkzy.casl.userservice;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

import gg.sparkzy.casl.userservice.entities.User;
import gg.sparkzy.casl.userservice.messaging.Message;

/**
 * User micro-service main for CASL
 * 
 * @author Bobby McGetrick
 *
 */
@SpringBootApplication
@EnableCircuitBreaker
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

}
