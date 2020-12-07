package com.example.hamcrest.HamcrestAssertions.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Customer {
    private Integer id;
    private String name;
    private boolean updated;
}
