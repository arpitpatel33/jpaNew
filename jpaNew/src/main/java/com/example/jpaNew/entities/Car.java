package com.example.jpaNew.entities;

import javax.persistence.*;

@Entity(name = "Car")
@Table(name = "car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "model_year")
    private Long model;

    @Column(name = "make_type")
    private String type;

    @Column(name = "fuel")
    private String fuel;

    public Car() {
    }

    public Car(Long id, String name, Long model, String type, String fuel) {
        this.id = id;
        this.name = name;
        this.model = model;
        this.type = type;
        this.fuel = fuel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getModel() {
        return model;
    }

    public void setModel(Long model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }
}
