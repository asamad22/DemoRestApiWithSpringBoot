package com.example.springbootrestapi.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(nullable = false, name = "first_name")
    private String firstName;
    @Column(nullable = false, name = "last_name")
    private String lastName;
    @Column(unique = true, nullable = false, name = "email")
    private String email;

}
