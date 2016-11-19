package org.wahlzeit.model;

public class SphericCoordinate implements Coordinate {
    public static final double EARTH_RADIUS_KM = 6371;

    private double latitude;
    private double longitude;
    private double radius;

    /**
     * Creates a new Coodinate from latitude and longitude in degrees
     * @param latitude in degrees
     * @param longitude in degrees
     * @param radius in km
     */
    public SphericCoordinate(double latitude, double longitude, double radius) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.radius = radius;
    }

    @Override
    public double getDistance(Coordinate coordinate) {
        return toCartesian().getDistance(coordinate);
    }

    @Override
    public CartesianCoordinate toCartesian() {
        return new CartesianCoordinate(
                radius * Math.cos(getLatitudeRadians()) * Math.cos(getLongitudeRadians()),
                radius * Math.cos(getLatitudeRadians()) * Math.sin(getLongitudeRadians()),
                radius * Math.sin(getLatitudeRadians()));
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitudeRadians() { return Math.toRadians(getLatitude());}

    public double getLongitudeRadians() { return Math.toRadians(getLongitude()); }

}
