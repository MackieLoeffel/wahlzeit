package org.wahlzeit.model;

public class Location {

    private final Coordinate coordinate;

    public Location(SphericCoordinate coordinate) {
        this.coordinate = coordinate;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }
}
