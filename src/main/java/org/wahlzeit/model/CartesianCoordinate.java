package org.wahlzeit.model;

public class CartesianCoordinate extends AbstractCoordinate {
    private double x;
    private double y;
    private double z;

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
