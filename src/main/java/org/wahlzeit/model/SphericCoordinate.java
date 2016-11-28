package org.wahlzeit.model;

public class SphericCoordinate extends AbstractCoordinate {
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
        checkRadius(radius);
        this.latitude = latitude;
        this.longitude = longitude;
        this.radius = radius;
    }

    public double asCartesianX() {
        return radius * Math.cos(getLatitudeRadians()) * Math.cos(getLongitudeRadians());
    }

    public double asCartesianY() {
        return radius * Math.cos(getLatitudeRadians()) * Math.sin(getLongitudeRadians());
    }

    public double asCartesianZ() {
        return radius * Math.sin(getLatitudeRadians());
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitudeRadians() { return Math.toRadians(getLatitude());}

    public double getLongitudeRadians() { return Math.toRadians(getLongitude()); }

    private void checkRadius(double radius) {
        if (radius < 0) {
            throw new IllegalArgumentException("radius must be positive, was " + radius);
        }
    }
}
