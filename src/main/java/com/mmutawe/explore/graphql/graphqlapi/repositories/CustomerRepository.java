package com.mmutawe.explore.graphql.graphqlapi.repositories;

import com.mmutawe.explore.graphql.graphqlapi.entities.Customer;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface CustomerRepository extends ReactiveCrudRepository<Customer, Long> {

    Flux<Customer> findByFirstName(String firstName);
}
