package com.mmutawe.explore.graphql.graphqlapi.controllers;

import com.mmutawe.explore.graphql.graphqlapi.entities.Customer;
import com.mmutawe.explore.graphql.graphqlapi.entities.Order;
import com.mmutawe.explore.graphql.graphqlapi.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
@AllArgsConstructor
public class GraphQLController {

    private final CustomerRepository repository;

//    @SchemaMapping (typeName = "Query", field = "customers")
    // QueryMapping is a special case of SchemaMapping where it defines the root Query schema
    @QueryMapping // (name = "customers") the default name value is the name of the method
    Flux<Customer> customers() {
        return this.repository.findAll();
    }

    @QueryMapping
    Flux<Customer> customersByFirstName(@Argument String firstName){
        return this.repository.findByFirstName(firstName);
    }

    @SchemaMapping(typeName = "Customer")
    Flux<Order> orders(Customer customer) {

        Random random = new Random();
        List<Order> orders = new ArrayList<>();

        int numOrders = random.nextInt(10);
        for (int i = 0; i < numOrders; i++) {
            orders.add(Order.builder()
                    .id((long) (i + 1))
                    .customerId(customer.getId())
                    .build());
        }

        return Flux.fromIterable(orders);
    }

//    @SchemaMapping(typeName = "Mutation", field = "addCustomer")
    @MutationMapping
    Mono<Customer> addCustomer (@Argument String firstName,@Argument String lastName) {

//        Random random = new Random();
//        Long id = random.nextLong() % 100;

        return this.repository.save(
                Customer.builder()
//                        .id(id)
                        .firstName(firstName)
                        .lastName(lastName)
                        .build()
        );
    }
}
