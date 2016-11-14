package org.wahlzeit.model;

public class CartesianCoordinate implements Coordinate {
    private final double x;
    private final double y;
    private final double z;

    /**
     * Origin is middle of the Earth, all Parameters in km
     * @param x in km
     * @param y in km
     * @param z in km
     */
    public CartesianCoordinate(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public double getDistance(Coordinate coordinate) {
        return getDistance(coordinate.toCartesian());
    }

    public double getDistance(CartesianCoordinate coordinate) {
        double dx = getX() - coordinate.getX();
        double dy = getY() - coordinate.getY();
        double dz = getZ() - coordinate.getZ();
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    @Override
    public CartesianCoordinate toCartesian() {
        return this;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    @Override
    public String toString() {
        return "CartesianCoordinate: x: " + x + ", y:" + y + ", z:" + z;
    }
}
