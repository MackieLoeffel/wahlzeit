package org.wahlzeit.model;

import java.util.HashMap;

import static org.wahlzeit.utils.AssertUtil.assertArgumentValidDouble;

/**
 *	@PatternInstance:
 *   patternName = “ValueObject”
 *   participants = {
 *	   “ValueObject”
 *   }
 */
public class SphericCoordinate extends AbstractCoordinate {
    public static final double EARTH_RADIUS_KM = 6371;

    private static final HashMap<SphericCoordinate, SphericCoordinate> existingCoordinates = new HashMap<>();

    private final double latitude;
    private final double longitude;
    private final double radius;

    /**
     * Creates a new Coodinate from latitude and longitude in degrees
     * @param latitude in degrees
     * @param longitude in degrees
     * @param radius in km
     */
    public static SphericCoordinate create(double latitude, double longitude, double radius) {
        SphericCoordinate coordinate =  new SphericCoordinate(latitude, longitude, radius);
        SphericCoordinate result = existingCoordinates.get(coordinate);
        if(result == null) {
            synchronized (existingCoordinates) {
                result = existingCoordinates.get(coordinate);
                if(result == null) {
                    result = coordinate;
                    existingCoordinates.put(coordinate, result);
                }
            }
        }
        return result;
    }

    private SphericCoordinate(double latitude, double longitude, double radius) {
        assertArgumentValidDouble("latitude", latitude);
        assertArgumentValidDouble("longitude", longitude);
        checkRadius(radius);

        // normalize
        // normalize longitude to -180 < longitude <= 180
        longitude = normalize(longitude);
        // normalize latitude to -90 <= latitude <= 90
        latitude = normalize(latitude);
        if(Math.abs(latitude) > 90) {
            longitude = normalize(longitude + 180);
            if (latitude > 0) {
                latitude = 180 - latitude;
            } else {
                latitude = -180 - latitude;
            }
        }

        this.latitude = latitude;
        this.longitude = longitude;
        this.radius = radius;
    }

    private double normalize(double degree) {
        degree %= 360;
        if (degree < 0) {
            degree += 360;
        }
        if(degree > 180) {
            degree -= 360;
        }
        return degree;
    }

    /**
     *	@PatternInstance:
     *   patternName = “TemplateMethod”
     *   participants = {
     *	   “TemplateMethod”, “Step”
     *   }
     */
    public double asCartesianX() {
        return radius * Math.cos(getLatitudeRadians()) * Math.cos(getLongitudeRadians());
    }

    /**
     *	@PatternInstance:
     *   patternName = “TemplateMethod”
     *   participants = {
     *	   “TemplateMethod”, “Step”
     *   }
     */
    public double asCartesianY() {
        return radius * Math.cos(getLatitudeRadians()) * Math.sin(getLongitudeRadians());
    }

    /**
     *	@PatternInstance:
     *   patternName = “TemplateMethod”
     *   participants = {
     *	   “TemplateMethod”, “Step”
     *   }
     */
    public double asCartesianZ() {
        return radius * Math.sin(getLatitudeRadians());
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getRadius() {
        return radius;
    }

    public double getLatitudeRadians() { return Math.toRadians(getLatitude());}

    public double getLongitudeRadians() { return Math.toRadians(getLongitude()); }

    private void checkRadius(double radius) {
        if (radius < 0) {
            throw new IllegalArgumentException("radius must be positive, was " + radius);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SphericCoordinate that = (SphericCoordinate) o;

        return Double.compare(that.getLatitude(), getLatitude()) == 0
                && Double.compare(that.getLongitude(), getLongitude()) == 0
                && Double.compare(that.getRadius(), getRadius()) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(getLatitude());
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getLongitude());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getRadius());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
