package com.example.jpaNew.entities;

import javax.persistence.*;

@Entity(name = "Music")
@Table(name = "musical_instruments")
public class Music {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "origin")
    private String origin;

    @Column(name = "year_of_origin")
    private Long originCountry;

    @Column(name = "expert")
    private String expert;

    public Music() {
    }

    public Music(Long id, String name, String origin, Long originCountry, String expert) {
        this.id = id;
        this.name = name;
        this.origin = origin;
        this.originCountry = originCountry;
        this.expert = expert;
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

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public Long getOriginCountry() {
        return originCountry;
    }

    public void setOriginCountry(Long originCountry) {
        this.originCountry = originCountry;
    }

    public String getExpert() {
        return expert;
    }

    public void setExpert(String expert) {
        this.expert = expert;
    }
}
