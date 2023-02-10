package com.example.jpaNew.entities;

import javax.persistence.*;

@Entity(name = "Scooter")
@Table(name = "scooter")
public class Scooter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "no_of_gears")
    private Long gears;

    @Column(name = "origin_country")
    private String country;

    public Scooter() {
    }

    public Scooter(Long id, String name, Long gears, String country) {
        this.id = id;
        this.name = name;
        this.gears = gears;
        this.country = country;
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

    public Long getGears() {
        return gears;
    }

    public void setGears(Long gears) {
        this.gears = gears;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
