package org.wahlzeit.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class AbstractCoordinateTest {

    @Test
    public void testGetDistanceSphericCartesian() {
        CartesianCoordinate cartesianCoordinate = new CartesianCoordinate(1, 1, 1);
        SphericCoordinate sphericCoordinate = new SphericCoordinate(90, 0, 1);

        assertEquals(Math.sqrt(2), sphericCoordinate.getDistance(cartesianCoordinate), 0.01);
    }

    @Test
    public void testGetDistanceCartesianSpheric() {
        CartesianCoordinate cartesianCoordinate = new CartesianCoordinate(0, 2, 1);
        SphericCoordinate sphericCoordinate = new SphericCoordinate(90, 0, 1);

        assertEquals(2, cartesianCoordinate.getDistance(sphericCoordinate), 0.01);
    }

    @Test
    public void testisEqualSphericCartesian() {
        CartesianCoordinate cartesianCoordinate = new CartesianCoordinate(1, 1, 0);
        SphericCoordinate sphericCoordinate = new SphericCoordinate(0, 45, Math.sqrt(2));

        assertTrue(sphericCoordinate.isEqual(cartesianCoordinate));
    }

    @Test
    public void testisEqualSphericCartesianFalse() {
        CartesianCoordinate cartesianCoordinate = new CartesianCoordinate(1, 1, 1);
        SphericCoordinate sphericCoordinate = new SphericCoordinate(90, 0, 1);

        assertFalse(sphericCoordinate.isEqual(cartesianCoordinate));
    }

    @Test
    public void testisEqualCartesianSpheric() {
        CartesianCoordinate cartesianCoordinate = new CartesianCoordinate(0, 0, 0);
        SphericCoordinate sphericCoordinate = new SphericCoordinate(90, 180, 0);

        assertTrue(cartesianCoordinate.isEqual(sphericCoordinate));
    }

    @Test
    public void testisEqualCartesianSphericFalse() {
        CartesianCoordinate cartesianCoordinate = new CartesianCoordinate(1, 1, 1);
        SphericCoordinate sphericCoordinate = new SphericCoordinate(90, 0, 1);

        assertFalse(cartesianCoordinate.isEqual(sphericCoordinate));
    }
}
