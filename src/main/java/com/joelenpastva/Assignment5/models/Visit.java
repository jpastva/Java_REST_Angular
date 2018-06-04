package com.joelenpastva.Assignment5.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PLANETVISIT")
public class Visit {

    public Visit() {}

    @Column(name = "STARSHIPID")
    private String starshipId;


    @Column(name = "PLANETID")
    private String planetId;

    @Id
    @Column(name = "ARRIVALSTARDATE")
    private int arrivalStarDate;

    @Column(name = "DEPARTURESTARDATE")
    private int departureStarDate;


    public String getStarshipId() {
        return starshipId;
    }

    public void setStarshipId(String starshipId)
    {
        this.starshipId = starshipId;
    }

    public String getPlanetId() {
        return planetId;
    }

    public void setPlanetId(String planetId) {
        this.planetId = planetId;
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
