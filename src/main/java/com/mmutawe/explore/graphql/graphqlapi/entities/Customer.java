package com.mmutawe.explore.graphql.graphqlapi.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Customer {
    @Id
    private Long id;
    String firstName;
    String lastName;
}
