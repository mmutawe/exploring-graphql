package com.mmutawe.explore.graphql.graphqlapi.entities;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Builder
@Table(value = "customers")
public class Customer {
    @Id
    private Long id;
    String firstName;
    String lastName;
}
