package com.workintech.s18d4.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "address" , schema = "fsweb")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="street")
    private String street;

    @Column(name = "no")
    private int no;

    @Column(name = "country")
    private String country;

    @Column(name = "description")
    private String description;

    @Column(name = "city")
    private String city;

    @OneToOne(mappedBy = "address")
    private Customer customer;


}
