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
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getDistance(Coordinate other) {
        // see https://en.wikipedia.org/wiki/Great-circle_distance
        // the Math.min(1, ...) is needed, because the calculation has precision problems
        // and this function would return NaN, if the two coordinates are very close to another
        return EARTH_RADIUS * Math.acos(Math.min(1,
                Math.sin(getLatitudeRadians()) * Math.sin(other.getLatitudeRadians())
                + Math.cos(getLatitudeRadians()) * Math.cos(other.getLatitudeRadians())
                        * Math.cos(getLongitudeRadians() - other.getLongitudeRadians())));
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
