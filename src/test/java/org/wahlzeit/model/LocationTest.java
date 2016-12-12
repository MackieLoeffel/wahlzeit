package org.wahlzeit.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LocationTest {

    @Test
    public void testConstructor() {
        SphericCoordinate coordinate = SphericCoordinate.create(111, 222, SphericCoordinate.EARTH_RADIUS_KM);
        Location location = new Location(coordinate);

        assertEquals(coordinate, location.getCoordinate());
    }
}
