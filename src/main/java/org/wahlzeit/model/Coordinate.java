package org.wahlzeit.model;

public interface Coordinate {

    double getDistance(Coordinate coordinate);

    CartesianCoordinate toCartesian();
}
