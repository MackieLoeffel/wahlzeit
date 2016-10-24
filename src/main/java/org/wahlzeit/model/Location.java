package org.wahlzeit.model;

public class Location {

    private final Coordinate coordinate;

    public Location(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }
}
