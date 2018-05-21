package com.joelenpastva.Assignment5.models;

import javax.persistence.*;

public class Visit {

    public Visit() {}

    @ManyToOne
    private Starship starship;

    @ManyToOne
    private Planet planet;

    @Column(name = "ARRIVALSTARDATE")
    private int arrivalStarDate;

    @Column(name = "DEPARTURESTARDATE")
    private int departureStarDate;

    public Starship getStarship() {
        return starship;
    }

    public void setStarship(Starship starship) {
        this.starship = starship;
    }

    public Planet getPlanet() {
        return planet;
    }

    public void setPlanet(Planet planet) {
        this.planet = planet;
    }

    public int getArrivalStarDate() {
        return arrivalStarDate;
    }

    public void setArrivalStarDate(int arrivalStarDate) {
        this.arrivalStarDate = arrivalStarDate;
    }

    public int getDepartureStarDate() {
        return departureStarDate;
    }

    public void setDepartureStarDate(int departureStarDate) {
        this.departureStarDate = departureStarDate;
    }
}
