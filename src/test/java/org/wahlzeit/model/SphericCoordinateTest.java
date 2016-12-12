package org.wahlzeit.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class SphericCoordinateTest {

    @Test
    public void testConstructor() {
        SphericCoordinate coordinate = SphericCoordinate.create(12, 34, SphericCoordinate.EARTH_RADIUS_KM);

        assertEquals(12, coordinate.getLatitude(), 0);
        assertEquals(34, coordinate.getLongitude(), 0);
    }

    @Test
    public void testRadians() {
        SphericCoordinate coordinate0_90 = SphericCoordinate.create(0, 90, SphericCoordinate.EARTH_RADIUS_KM);
        SphericCoordinate coordinate180_360 = SphericCoordinate.create(180, 360, SphericCoordinate.EARTH_RADIUS_KM);
        SphericCoordinate coordinateNeg = SphericCoordinate.create(-90, -180, SphericCoordinate.EARTH_RADIUS_KM);
        SphericCoordinate coordinateRandom = SphericCoordinate.create(-876, 1234, SphericCoordinate.EARTH_RADIUS_KM);

        assertEquals(0, coordinate0_90.getLatitudeRadians(), 0);
        assertEquals(Math.PI / 2, coordinate0_90.getLongitudeRadians(), 0.01);
        assertEquals(0, coordinate180_360.getLatitudeRadians(), 0.01);
        assertEquals(Math.PI, coordinate180_360.getLongitudeRadians(), 0.01);
        assertEquals(-Math.PI / 2, coordinateNeg.getLatitudeRadians(), 0.01);
        assertEquals(Math.PI, coordinateNeg.getLongitudeRadians(), 0.01);
        assertEquals(-Math.PI * 24 / 180, coordinateRandom.getLatitudeRadians(), 0.01);
        assertEquals(-Math.PI * 26 / 180, coordinateRandom.getLongitudeRadians(), 0.01);
    }

    @Test
    public void testToCartesianNorth() {
        SphericCoordinate a = SphericCoordinate.create(90, 0, SphericCoordinate.EARTH_RADIUS_KM);

        assertEquals(0, a.asCartesianX(), 1);
        assertEquals(0, a.asCartesianY(), 1);
        assertEquals(SphericCoordinate.EARTH_RADIUS_KM, a.asCartesianZ(), 1);
    }

    @Test
    public void testToCartesianSouth() {
        SphericCoordinate a = SphericCoordinate.create(-90, 0, SphericCoordinate.EARTH_RADIUS_KM);

        assertEquals(0, a.asCartesianX(), 1);
        assertEquals(0, a.asCartesianY(), 1);
        assertEquals(-SphericCoordinate.EARTH_RADIUS_KM, a.asCartesianZ(), 1);
    }

    @Test
    public void testToCartesianWest() {
        SphericCoordinate a = SphericCoordinate.create(0, -90, SphericCoordinate.EARTH_RADIUS_KM);

        assertEquals(0, a.asCartesianX(), 1);
        assertEquals(-SphericCoordinate.EARTH_RADIUS_KM, a.asCartesianY(), 1);
        assertEquals(0, a.asCartesianZ(), 1);
    }

    @Test
    public void testToCartesianEast() {
        SphericCoordinate a = SphericCoordinate.create(0, 90, SphericCoordinate.EARTH_RADIUS_KM);

        assertEquals(0, a.asCartesianX(), 1);
        assertEquals(SphericCoordinate.EARTH_RADIUS_KM, a.asCartesianY(), 1);
        assertEquals(0, a.asCartesianZ(), 1);
    }

    @Test
    public void testToCartesianFront() {
        SphericCoordinate a = SphericCoordinate.create(0, 0, SphericCoordinate.EARTH_RADIUS_KM);

        assertEquals(SphericCoordinate.EARTH_RADIUS_KM, a.asCartesianX(), 1);
        assertEquals(0, a.asCartesianY(), 1);
        assertEquals(0, a.asCartesianZ(), 1);
    }

    @Test
    public void testToCartesianBack() {
        SphericCoordinate a = SphericCoordinate.create(0, 180, SphericCoordinate.EARTH_RADIUS_KM);

        assertEquals(-SphericCoordinate.EARTH_RADIUS_KM, a.asCartesianX(), 1);
        assertEquals(0, a.asCartesianY(), 1);
        assertEquals(0, a.asCartesianZ(), 1);
    }

    @Test
    public void testGetDistanceSamePoint() {
        SphericCoordinate a = SphericCoordinate.create(12, 34, SphericCoordinate.EARTH_RADIUS_KM);
        SphericCoordinate b = SphericCoordinate.create(12, 34, SphericCoordinate.EARTH_RADIUS_KM);

        assertEquals(0, a.getDistance(b), 0);
    }

    @Test
    public void testGetDistanceSamePointOtherCoordinates() {
        SphericCoordinate a = SphericCoordinate.create(12, 34, SphericCoordinate.EARTH_RADIUS_KM);
        SphericCoordinate b = SphericCoordinate.create(732, -686, SphericCoordinate.EARTH_RADIUS_KM);

        assertEquals(0, a.getDistance(b), 1);
    }

    @Test
    public void testGetDistance180Degree() {
        SphericCoordinate a = SphericCoordinate.create(192, 34, SphericCoordinate.EARTH_RADIUS_KM);
        SphericCoordinate b = SphericCoordinate.create(12, 34, SphericCoordinate.EARTH_RADIUS_KM);

        assertEquals(SphericCoordinate.EARTH_RADIUS_KM * 2, a.getDistance(b), 1);
    }

    @Test
    public void testGetDistanceNorthSouth() {
        SphericCoordinate a = SphericCoordinate.create(90, 0, SphericCoordinate.EARTH_RADIUS_KM);
        SphericCoordinate b = SphericCoordinate.create(-90, 0, SphericCoordinate.EARTH_RADIUS_KM);

        assertEquals(SphericCoordinate.EARTH_RADIUS_KM * 2, a.getDistance(b), 1);
    }

    @Test
    public void testGetDistanceNorthNorth() {
        SphericCoordinate a = SphericCoordinate.create(90, 0, SphericCoordinate.EARTH_RADIUS_KM);
        SphericCoordinate b = SphericCoordinate.create(-270, 0, SphericCoordinate.EARTH_RADIUS_KM);

        assertEquals(0, a.getDistance(b), 1);
    }

    @Test
    public void testGetDistanceEastEast() {
        SphericCoordinate a = SphericCoordinate.create(0, 90, SphericCoordinate.EARTH_RADIUS_KM);
        SphericCoordinate b = SphericCoordinate.create(0, -270, SphericCoordinate.EARTH_RADIUS_KM);

        assertEquals(0, a.getDistance(b), 1);
    }

    @Test
    public void testGetDistanceWestEast() {
        SphericCoordinate a = SphericCoordinate.create(0, 90, SphericCoordinate.EARTH_RADIUS_KM);
        SphericCoordinate b = SphericCoordinate.create(0, -90, SphericCoordinate.EARTH_RADIUS_KM);

        assertEquals(SphericCoordinate.EARTH_RADIUS_KM * 2, a.getDistance(b), 1);
    }

    @Test
    public void testGetDistanceDiagonal() {
        SphericCoordinate a = SphericCoordinate.create(0, 0, SphericCoordinate.EARTH_RADIUS_KM);
        SphericCoordinate b = SphericCoordinate.create(-111, -222, SphericCoordinate.EARTH_RADIUS_KM);

        assertEquals(7717, a.getDistance(b), 1);
    }

    @Test
    public void testGetDistanceDiagonalNonZeroStart() {
        SphericCoordinate a = SphericCoordinate.create(123, 0, SphericCoordinate.EARTH_RADIUS_KM);
        SphericCoordinate b = SphericCoordinate.create(12, -222, SphericCoordinate.EARTH_RADIUS_KM);

        assertEquals(5906, a.getDistance(b), 1);
    }

    @Test
    public void testIsEqual() {
        SphericCoordinate a = SphericCoordinate.create(-343, 348, SphericCoordinate.EARTH_RADIUS_KM);
        SphericCoordinate b = SphericCoordinate.create(377, -12, SphericCoordinate.EARTH_RADIUS_KM);

        assertTrue(a.isEqual(b));
    }

    @Test
    public void testIsEqualFalse() {
        SphericCoordinate a = SphericCoordinate.create(-343, 348, SphericCoordinate.EARTH_RADIUS_KM);
        SphericCoordinate b = SphericCoordinate.create(377, -13, SphericCoordinate.EARTH_RADIUS_KM);

        assertFalse(a.isEqual(b));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeRadius() throws Exception {
        SphericCoordinate.create(1, 2, -1);
    }

    @Test
    public void testEqualsNormal() {
        SphericCoordinate a = SphericCoordinate.create(10, 20, 1);
        SphericCoordinate b = SphericCoordinate.create(10, 20, 1);
        assertTrue(a.equals(b));
    }

    @Test
    public void testEqualsNegative() {
        SphericCoordinate a = SphericCoordinate.create(-10, -20, 1);
        SphericCoordinate b = SphericCoordinate.create(-10, -20, 1);
        assertTrue(a.equals(b));
    }

    @Test
    public void testEqualsWraparoundLatitude() {
        SphericCoordinate a = SphericCoordinate.create(-10, 20, 1);
        SphericCoordinate b = SphericCoordinate.create(350, 20, 1);
        assertTrue(a.equals(b));
    }

    @Test
    public void testEqualsWraparoundLongitude() {
        SphericCoordinate a = SphericCoordinate.create(-10, 20, 1);
        SphericCoordinate b = SphericCoordinate.create(350, -700, 1);
        assertTrue(a.equals(b));
    }

    @Test
    public void testEqualsLatitudeGreater90Positive() {
        SphericCoordinate a = SphericCoordinate.create(100, 20, 1);
        SphericCoordinate b = SphericCoordinate.create(80, -520, 1);
        assertTrue(a.equals(b));
    }

    @Test
    public void testEqualsLatitudeGreater90Negative() {
        SphericCoordinate a = SphericCoordinate.create(-100, -20, 1);
        SphericCoordinate b = SphericCoordinate.create(-80, 520, 1);
        assertTrue(a.equals(b));
    }

    @Test
    public void testEqualsOperator() {
        SphericCoordinate a = SphericCoordinate.create(10, 20, 1);
        SphericCoordinate b = SphericCoordinate.create(10, 20, 1);
        assertTrue(a == b);
    }

    @Test
    public void testEqualsFail() {
        SphericCoordinate a = SphericCoordinate.create(-101, -20, 1);
        SphericCoordinate b = SphericCoordinate.create(-80, 520, 1);
        assertFalse(a.equals(b));
    }

    @Test
    public void testHashCode() {
        SphericCoordinate a = SphericCoordinate.create(-10, 20, 1);
        SphericCoordinate b = SphericCoordinate.create(350, -700, 1);
        assertEquals(a.hashCode(), b.hashCode());
    }
}
