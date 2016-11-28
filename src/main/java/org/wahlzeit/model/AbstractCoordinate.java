package org.wahlzeit.model;

public abstract class AbstractCoordinate implements Coordinate {
    public static final double EPSILON = 0.0000001;

    @Override
    public boolean isEqual(Coordinate other) {
        return Math.abs(getDistance(other)) < EPSILON;
    }

    @Override
    public double getDistance(Coordinate other) {
        double dx = asCartesianX() - other.asCartesianX();
        double dy = asCartesianY() - other.asCartesianY();
        double dz = asCartesianZ() - other.asCartesianZ();
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }
}
