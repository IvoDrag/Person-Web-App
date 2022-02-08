package com.ivodrag.personcrudwebapp.model;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Person {
    private int id;
    private String name;
    private String gender;
    private int age;
}
