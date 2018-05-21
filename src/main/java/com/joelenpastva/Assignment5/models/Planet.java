package com.joelenpastva.Assignment5.models;

import javax.persistence.Column;
import javax.persistence.Id;

public class Planet {

    @Id
    @Column(name = "PLANETID")
    private int id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "RADIUS")
    private int radius;

    @Column(name = "ATMOSPHERE")
    private String atmosphere;

    public Planet() {}

    public Planet(int id, String name, int radius) {
        this.id = id;
        this.name = name;
        this.radius = radius;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
}
