package com.mmutawe.explore.graphql.graphqlapi.entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Order {
    private Long id;
    private Long customerId;
}
