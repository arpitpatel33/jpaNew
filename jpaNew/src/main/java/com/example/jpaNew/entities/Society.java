package com.example.jpaNew.entities;

import javax.persistence.*;

@Entity(name = "Society")
@Table(name = "society")
public class Society {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "house_id")
    private Long id;

    @Column(name = "owner_name")
    private String name;

    @Column(name = "cars_owned")
    private String cars;

    @Column(name = "members")
    private Long members;

    @Column(name = "plot_size")
    private Long size;

    public Society() {
    }

    public Society(Long id, String name, String cars, Long members, Long size) {
        this.id = id;
        this.name = name;
        this.cars = cars;
        this.members = members;
        this.size = size;
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

    public String getCars() {
        return cars;
    }

    public void setCars(String cars) {
        this.cars = cars;
    }

    public Long getMembers() {
        return members;
    }

    public void setMembers(Long members) {
        this.members = members;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }
}

