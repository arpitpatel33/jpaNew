package com.example.jpaNew.entities;

import javax.persistence.*;

@Entity(name = "Mobile")
@Table(name = "mobile")
public class Mobile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "company")
    private String company;

    @Column(name = "model")
    private Long model;

    @Column(name = "camera")
    private String camera;

    @Column(name = "color")
    private String color;

    public Mobile() {
    }

    public Mobile(Long id, String company, Long model, String camera, String color) {
        this.id = id;
        this.company = company;
        this.model = model;
        this.camera = camera;
        this.color = color;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Long getModel() {
        return model;
    }

    public void setModel(Long model) {
        this.model = model;
    }

    public String getCamera() {
        return camera;
    }

    public void setCamera(String camera) {
        this.camera = camera;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
