package com.jagadish.aws.lambda.repository;

import com.jagadish.aws.lambda.domain.Order;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
public class OrderDao {
    public List<Order> buildOrders(){
        return Stream.of(new Order(1,"Apple",10000,1),
                new Order(2,"Samsung",20000,2),
                new Order(3,"Nokia",30000,3)).collect(Collectors.toList());
    }
}
