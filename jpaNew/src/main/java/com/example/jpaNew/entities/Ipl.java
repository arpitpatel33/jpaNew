package com.example.jpaNew.entities;

import javax.persistence.*;

@Entity(name = "Ipl")
@Table(name = "ipl2023")
public class Ipl {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "city")
    private String city;

    @Column(name = "captain")
    private String captain;

    @Column(name = "total_players")
    private Long players;

    public Ipl() {
    }

    public Ipl(Long id, String name, String city, String captain, Long players) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.captain = captain;
        this.players = players;
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

    public String getCaptain() {
        return captain;
    }

    public void setCaptain(String captain) {
        this.captain = captain;
    }

    public Long getPlayers() {
        return players;
    }

    public void setPlayers(Long players) {
        this.players = players;
    }
}
