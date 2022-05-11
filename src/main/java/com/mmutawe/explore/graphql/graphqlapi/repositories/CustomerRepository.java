package com.mmutawe.explore.graphql.graphqlapi.repositories;

import com.mmutawe.explore.graphql.graphqlapi.entities.Customer;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface CustomerRepository extends ReactiveCrudRepository<Customer, Long> {
}
