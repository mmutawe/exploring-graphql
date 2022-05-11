package com.mmutawe.explore.graphql.graphqlapi.dtos;

import com.mmutawe.explore.graphql.graphqlapi.entities.Customer;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerEvent {
    private Customer customer;
    private CustomerEventType type;
}
