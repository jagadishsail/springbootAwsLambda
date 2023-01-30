package com.jagadish.aws.lambda;

import com.jagadish.aws.lambda.domain.Order;
import com.jagadish.aws.lambda.repository.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@SpringBootApplication
public class SpringbootAwsLambdaApplication {

	@Autowired
	private OrderDao orderDao;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootAwsLambdaApplication.class, args);
	}

	@Bean
	public Supplier<List<Order>> orders(){
		return () -> orderDao.buildOrders();
	}

	@Bean
	public Function<String, List<Order>> findOrderByName(){
		return (name) -> orderDao.buildOrders().stream().filter(order -> order.getName().equals(name)).collect(Collectors.toList());
	}
}
