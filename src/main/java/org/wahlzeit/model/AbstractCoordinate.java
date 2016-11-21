package org.wahlzeit.model;

public abstract class AbstractCoordinate implements Coordinate {
    public static final double EPSILON = 0.0000001;

    @Override
    public boolean isEqual(Coordinate other) {
        return Math.abs(getDistance(other)) < EPSILON;
    }

    @Override
    public double getDistance(Coordinate other) {
        CartesianCoordinate cartesianThis = toCartesian();
        CartesianCoordinate cartesianOther = other.toCartesian();
        double dx = cartesianThis.getX() - cartesianOther.getX();
        double dy = cartesianThis.getY() - cartesianOther.getY();
        double dz = cartesianThis.getZ() - cartesianOther.getZ();
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }
}
