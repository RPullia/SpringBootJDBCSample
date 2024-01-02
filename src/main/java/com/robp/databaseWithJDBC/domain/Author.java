package com.robp.databaseWithJDBC.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // annotation lombok che crea equals, hashcode, toString, getter e setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Author {

    private Long id;
    private String name;
    private Integer age;
}
