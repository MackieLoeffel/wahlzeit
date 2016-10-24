package org.wahlzeit.model;

public class Coordinate {
    public static final double EARTH_RADIUS = 6371;

    private final double latitude;
    private final double longitude;

    /**
     * Creates a new Coodinate from latitude and longitude in degrees
     * @param latitude in degrees
     * @param longitude in degrees
     */
    public Coordinate(double latitude, double longitude) {
        this.latitude = normalizeDegrees(latitude);
        this.longitude = normalizeDegrees(longitude);
    }

    private double normalizeDegrees(double degree) {
        while(degree < 0) {
            degree += 360;
        }
        return degree % 360;
    }

    public double getDistance(Coordinate other) {
        // see https://en.wikipedia.org/wiki/Great-circle_distance
        return EARTH_RADIUS * Math.acos(
                Math.sin(Math.toRadians(latitude)) * Math.sin(Math.toRadians(other.latitude))
                + Math.cos(Math.toRadians(latitude)) * Math.cos(Math.toRadians(other.latitude))
                        * Math.cos(Math.toRadians(other.longitude - longitude)));
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}
