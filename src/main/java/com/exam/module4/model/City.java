package com.exam.module4.model;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "city")
@Data
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty(message = "Name must be not empty")
    private String name;

    @Min(value = 0, message = "Valid square input")
    private String square;

    @ManyToOne
    private Country country;


    @Min(value = 0, message = "Valid population input")
    private Float population;

    @Min(value = 0, message = "Valid gdp input")
    private Float gdp;

    @Column(columnDefinition = "TEXT")
    private String description;


}
