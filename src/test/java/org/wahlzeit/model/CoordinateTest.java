package org.wahlzeit.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CoordinateTest {

    @Test
    public void testConstructor() {
        Coordinate coordinate = new Coordinate(12, 34);

        assertEquals(12, coordinate.getLatitude(), 0);
        assertEquals(34, coordinate.getLongitude(), 0);
    }

    @Test
    public void testRadians() {
        Coordinate coordinate0_90 = new Coordinate(0, 90);
        Coordinate coordinate180_360 = new Coordinate(180, 360);
        Coordinate coordinateNeg = new Coordinate(-90, -180);
        Coordinate coordinateRandom = new Coordinate(-876, 1234);

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
    public void testGetDistanceSamePoint() {
        Coordinate a = new Coordinate(12, 34);
        Coordinate b = new Coordinate(12, 34);

        assertEquals(0, a.getDistance(b), 0);
    }

    @Test
    public void testGetDistanceSamePointOtherCoordinates() {
        Coordinate a = new Coordinate(12, 34);
        Coordinate b = new Coordinate(732, -686);

        assertEquals(0, a.getDistance(b), 0);
    }

    @Test
    public void testGetDistance180Degree() {
        Coordinate a = new Coordinate(192, 34);
        Coordinate b = new Coordinate(12, 34);

        assertEquals(20015, a.getDistance(b), 1);
    }

    @Test
    public void testGetDistanceNorthSouth() {
        Coordinate a = new Coordinate(90, 0);
        Coordinate b = new Coordinate(-90, 0);

        assertEquals(20015, a.getDistance(b), 1);
    }

    @Test
    public void testGetDistanceNorthNorth() {
        Coordinate a = new Coordinate(90, 0);
        Coordinate b = new Coordinate(-270, 0);

        assertEquals(0, a.getDistance(b), 0);
    }

    @Test
    public void testGetDistanceEastEast() {
        Coordinate a = new Coordinate(0, 90);
        Coordinate b = new Coordinate(0, -270);

        assertEquals(0, a.getDistance(b), 0);
    }

    @Test
    public void testGetDistanceWestEast() {
        Coordinate a = new Coordinate(0, 90);
        Coordinate b = new Coordinate(0, -90);

        assertEquals(20015, a.getDistance(b), 1);
    }

    @Test
    public void testGetDistanceDiagonal() {
        Coordinate a = new Coordinate(0, 0);
        Coordinate b = new Coordinate(-111, -222);

        assertEquals(8290, a.getDistance(b), 1);
    }

    @Test
    public void testGetDistanceDiagonalNonZeroStart() {
        Coordinate a = new Coordinate(123, 0);
        Coordinate b = new Coordinate(12, -222);

        assertEquals(6141, a.getDistance(b), 1);
    }
}
