package com.example.jpaNew.entities;

import javax.persistence.*;

@Entity(name = "Hotel")
@Table(name = "hotel")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "city")
    private String city;

    @Column(name = "total_rooms")
    private Long rooms;

    @Column(name = "category")
    private String category;

    public Hotel() {
    }

    public Hotel(Long id, String name, String city, Long rooms, String category) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.rooms = rooms;
        this.category = category;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Long getRooms() {
        return rooms;
    }

    public void setRooms(Long rooms) {
        this.rooms = rooms;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
