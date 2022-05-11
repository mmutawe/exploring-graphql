package com.mmutawe.explore.graphql.graphqlapi.controllers;

import com.mmutawe.explore.graphql.graphqlapi.entities.Customer;
import com.mmutawe.explore.graphql.graphqlapi.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;

@Controller
@AllArgsConstructor
public class GraphQLController {

    private final CustomerRepository repository;

    @SchemaMapping (typeName = "Query", field = "customers")
    Flux<Customer> getCustomers(){
        return this.repository.findAll();
    }

}
