package org.wahlzeit.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LocationTest {

    @Test
    public void testConstructor() {
        Coordinate coordinate = new Coordinate(111, 222);
        Location location = new Location(coordinate);

        assertEquals(coordinate.getLatitude(), location.getCoordinate().getLatitude(), 0);
        assertEquals(coordinate.getLongitude(), location.getCoordinate().getLongitude(), 0);
    }
}
