package org.wahlzeit.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SphericCoordinateTest {

    @Test
    public void testConstructor() {
        SphericCoordinate coordinate = new SphericCoordinate(12, 34, SphericCoordinate.EARTH_RADIUS_KM);

        assertEquals(12, coordinate.getLatitude(), 0);
        assertEquals(34, coordinate.getLongitude(), 0);
    }

    @Test
    public void testRadians() {
        SphericCoordinate coordinate0_90 = new SphericCoordinate(0, 90, SphericCoordinate.EARTH_RADIUS_KM);
        SphericCoordinate coordinate180_360 = new SphericCoordinate(180, 360, SphericCoordinate.EARTH_RADIUS_KM);
        SphericCoordinate coordinateNeg = new SphericCoordinate(-90, -180, SphericCoordinate.EARTH_RADIUS_KM);
        SphericCoordinate coordinateRandom = new SphericCoordinate(-876, 1234, SphericCoordinate.EARTH_RADIUS_KM);

        assertEquals(0, coordinate0_90.getLatitudeRadians(), 0);
        assertEquals(Math.PI / 2, coordinate0_90.getLongitudeRadians(), 0.01);
        assertEquals(Math.PI, coordinate180_360.getLatitudeRadians(), 0.01);
        assertEquals(Math.PI * 2, coordinate180_360.getLongitudeRadians(), 0.01);
        assertEquals(-Math.PI / 2, coordinateNeg.getLatitudeRadians(), 0.01);
        assertEquals(-Math.PI, coordinateNeg.getLongitudeRadians(), 0.01);
        assertEquals(-Math.PI * 876 / 180, coordinateRandom.getLatitudeRadians(), 0.01);
        assertEquals(Math.PI * 1234 / 180, coordinateRandom.getLongitudeRadians(), 0.01);
    }

    @Test
    public void testToCartesianNorth() {
        SphericCoordinate a = new SphericCoordinate(90, 0, SphericCoordinate.EARTH_RADIUS_KM);

        CartesianCoordinate c = a.toCartesian();
        assertEquals(0, c.getX(), 1);
        assertEquals(0, c.getY(), 1);
        assertEquals(SphericCoordinate.EARTH_RADIUS_KM, c.getZ(), 1);
    }

    @Test
    public void testToCartesianSouth() {
        SphericCoordinate a = new SphericCoordinate(-90, 0, SphericCoordinate.EARTH_RADIUS_KM);

        CartesianCoordinate c = a.toCartesian();
        assertEquals(0, c.getX(), 1);
        assertEquals(0, c.getY(), 1);
        assertEquals(-SphericCoordinate.EARTH_RADIUS_KM, c.getZ(), 1);
    }

    @Test
    public void testToCartesianWest() {
        SphericCoordinate a = new SphericCoordinate(0, -90, SphericCoordinate.EARTH_RADIUS_KM);

        CartesianCoordinate c = a.toCartesian();
        assertEquals(0, c.getX(), 1);
        assertEquals(-SphericCoordinate.EARTH_RADIUS_KM, c.getY(), 1);
        assertEquals(0, c.getZ(), 1);
    }

    @Test
    public void testToCartesianEast() {
        SphericCoordinate a = new SphericCoordinate(0, 90, SphericCoordinate.EARTH_RADIUS_KM);

        CartesianCoordinate c = a.toCartesian();
        assertEquals(0, c.getX(), 1);
        assertEquals(SphericCoordinate.EARTH_RADIUS_KM, c.getY(), 1);
        assertEquals(0, c.getZ(), 1);
    }

    @Test
    public void testToCartesianFront() {
        SphericCoordinate a = new SphericCoordinate(0, 0, SphericCoordinate.EARTH_RADIUS_KM);

        CartesianCoordinate c = a.toCartesian();
        assertEquals(SphericCoordinate.EARTH_RADIUS_KM, c.getX(), 1);
        assertEquals(0, c.getY(), 1);
        assertEquals(0, c.getZ(), 1);
    }

    @Test
    public void testToCartesianBack() {
        SphericCoordinate a = new SphericCoordinate(0, 180, SphericCoordinate.EARTH_RADIUS_KM);

        CartesianCoordinate c = a.toCartesian();
        assertEquals(-SphericCoordinate.EARTH_RADIUS_KM, c.getX(), 1);
        assertEquals(0, c.getY(), 1);
        assertEquals(0, c.getZ(), 1);
    }

    @Test
    public void testGetDistanceSamePoint() {
        SphericCoordinate a = new SphericCoordinate(12, 34, SphericCoordinate.EARTH_RADIUS_KM);
        SphericCoordinate b = new SphericCoordinate(12, 34, SphericCoordinate.EARTH_RADIUS_KM);

        assertEquals(0, a.getDistance(b), 0);
    }

    @Test
    public void testGetDistanceSamePointOtherCoordinates() {
        SphericCoordinate a = new SphericCoordinate(12, 34, SphericCoordinate.EARTH_RADIUS_KM);
        SphericCoordinate b = new SphericCoordinate(732, -686, SphericCoordinate.EARTH_RADIUS_KM);

        assertEquals(0, a.getDistance(b), 1);
    }

    @Test
    public void testGetDistance180Degree() {
        SphericCoordinate a = new SphericCoordinate(192, 34, SphericCoordinate.EARTH_RADIUS_KM);
        SphericCoordinate b = new SphericCoordinate(12, 34, SphericCoordinate.EARTH_RADIUS_KM);

        assertEquals(SphericCoordinate.EARTH_RADIUS_KM * 2, a.getDistance(b), 1);
    }

    @Test
    public void testGetDistanceNorthSouth() {
        SphericCoordinate a = new SphericCoordinate(90, 0, SphericCoordinate.EARTH_RADIUS_KM);
        SphericCoordinate b = new SphericCoordinate(-90, 0, SphericCoordinate.EARTH_RADIUS_KM);

        assertEquals(SphericCoordinate.EARTH_RADIUS_KM * 2, a.getDistance(b), 1);
    }

    @Test
    public void testGetDistanceNorthNorth() {
        SphericCoordinate a = new SphericCoordinate(90, 0, SphericCoordinate.EARTH_RADIUS_KM);
        SphericCoordinate b = new SphericCoordinate(-270, 0, SphericCoordinate.EARTH_RADIUS_KM);

        assertEquals(0, a.getDistance(b), 1);
    }

    @Test
    public void testGetDistanceEastEast() {
        SphericCoordinate a = new SphericCoordinate(0, 90, SphericCoordinate.EARTH_RADIUS_KM);
        SphericCoordinate b = new SphericCoordinate(0, -270, SphericCoordinate.EARTH_RADIUS_KM);

        assertEquals(0, a.getDistance(b), 1);
    }

    @Test
    public void testGetDistanceWestEast() {
        SphericCoordinate a = new SphericCoordinate(0, 90, SphericCoordinate.EARTH_RADIUS_KM);
        SphericCoordinate b = new SphericCoordinate(0, -90, SphericCoordinate.EARTH_RADIUS_KM);

        assertEquals(SphericCoordinate.EARTH_RADIUS_KM * 2, a.getDistance(b), 1);
    }

    @Test
    public void testGetDistanceDiagonal() {
        SphericCoordinate a = new SphericCoordinate(0, 0, SphericCoordinate.EARTH_RADIUS_KM);
        SphericCoordinate b = new SphericCoordinate(-111, -222, SphericCoordinate.EARTH_RADIUS_KM);

        assertEquals(7717, a.getDistance(b), 1);
    }

    @Test
    public void testGetDistanceDiagonalNonZeroStart() {
        SphericCoordinate a = new SphericCoordinate(123, 0, SphericCoordinate.EARTH_RADIUS_KM);
        SphericCoordinate b = new SphericCoordinate(12, -222, SphericCoordinate.EARTH_RADIUS_KM);

        assertEquals(5906, a.getDistance(b), 1);
    }
}
