package com.exam.module4.model;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "city")
@Data
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String square;

    @ManyToOne
    private Country country;

    private Float population;

    private Float gdp;

    @Column(columnDefinition = "TEXT")
    private String description;


}
