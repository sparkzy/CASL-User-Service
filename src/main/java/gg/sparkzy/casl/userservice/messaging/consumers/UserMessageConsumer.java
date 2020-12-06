package gg.sparkzy.casl.userservice.messaging.consumers;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.RabbitListenerContainerFactory;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import gg.sparkzy.casl.userservice.entities.User;
import gg.sparkzy.casl.userservice.messaging.dto.Message;
import gg.sparkzy.casl.userservice.services.UserService;

@Component
public class UserMessageConsumer {

	@Autowired
	UserService userService;

	@Bean
	public Jackson2JsonMessageConverter jackson2Converter() {
		Jackson2JsonMessageConverter converter = new Jackson2JsonMessageConverter();
		return converter;
	}

	@Bean
	public RabbitListenerContainerFactory rabbitListenerContainerFactory(ConnectionFactory connFactory) {
		SimpleRabbitListenerContainerFactory simpleRabbitListenerContainerFactory = new SimpleRabbitListenerContainerFactory();
		simpleRabbitListenerContainerFactory.setConnectionFactory(connFactory);
		simpleRabbitListenerContainerFactory.setMessageConverter(jackson2Converter());
		return simpleRabbitListenerContainerFactory;
	}

	@RabbitListener(queues = "user_queue")
	public void consumeMessageFromQueue(Message<User> userMessage) {
		System.out.println(" [x] Receive message from user_queue: " + userMessage);
		User newUser = userService.findById(userMessage.getObject().getId());
		System.out.println(" [x] Message contained: " + newUser);
	}

}
