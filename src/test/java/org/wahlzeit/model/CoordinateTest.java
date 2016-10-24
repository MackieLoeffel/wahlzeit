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
    public void testConstructorNormalizing() {
        Coordinate coordinate = new Coordinate(732, -686);

        assertEquals(12, coordinate.getLatitude(), 0);
        assertEquals(34, coordinate.getLongitude(), 0);
    }

    @Test
    public void testGetDistanceSamePoint() {
        Coordinate a = new Coordinate(12, 34);
        Coordinate b = new Coordinate(12, 34);

        assertEquals(a.getDistance(b), 0, 0);
    }

    @Test
    public void testGetDistance180Degree() {
        Coordinate a = new Coordinate(192, 34);
        Coordinate b = new Coordinate(12, 34);

        assertEquals(a.getDistance(b), 20015, 1);
    }}
