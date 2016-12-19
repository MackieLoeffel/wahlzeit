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
public class CartesianCoordinate extends AbstractCoordinate {
    private final double x;
    private final double y;
    private final double z;

    private static final HashMap<CartesianCoordinate, CartesianCoordinate> existingCoordinates = new HashMap<>();

    /**
     * Origin is middle of the Earth, all Parameters in km
     * @param x in km
     * @param y in km
     * @param z in km
     */
    public static CartesianCoordinate create(double x, double y, double z) {
        CartesianCoordinate coordinate = new CartesianCoordinate(x, y, z);
        CartesianCoordinate result = existingCoordinates.get(coordinate);
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

    private CartesianCoordinate(double x, double y, double z) {
        assertArgumentValidDouble("x", x);
        assertArgumentValidDouble("y", y);
        assertArgumentValidDouble("z", z);
        this.x = x;
        this.y = y;
        this.z = z;
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

    /**
     *	@PatternInstance:
     *   patternName = “TemplateMethod”
     *   participants = {
     *	   “TemplateMethod”, “Step”
     *   }
     */
    public double asCartesianX() {
        return getX();
    }

    /**
     *	@PatternInstance:
     *   patternName = “TemplateMethod”
     *   participants = {
     *	   “TemplateMethod”, “Step”
     *   }
     */
    public double asCartesianY() {
        return getY();
    }

    /**
     *	@PatternInstance:
     *   patternName = “TemplateMethod”
     *   participants = {
     *	   “TemplateMethod”, “Step”
     *   }
     */
    public double asCartesianZ() {
        return getZ();
    }

    @Override
    public String toString() {
        return "CartesianCoordinate: x: " + x + ", y:" + y + ", z:" + z;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CartesianCoordinate that = (CartesianCoordinate) o;

        return Double.compare(that.getX(), getX()) == 0
                && Double.compare(that.getY(), getY()) == 0
                && Double.compare(that.getZ(), getZ()) == 0;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(getX());
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getY());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getZ());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
