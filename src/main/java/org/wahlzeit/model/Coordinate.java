package org.wahlzeit.model;

import com.googlecode.objectify.annotation.Serialize;

@Serialize
public interface Coordinate {

    double getDistance(Coordinate coordinate);

    CartesianCoordinate toCartesian();
}
