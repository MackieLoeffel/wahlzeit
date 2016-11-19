package org.wahlzeit.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CartesianCoordinateTest {

	@Test
	public void testConstructor() {
		CartesianCoordinate coordinate = new CartesianCoordinate(1, 2, 3);

		assertEquals(1, coordinate.getX(), 0);
		assertEquals(2, coordinate.getY(), 0);
		assertEquals(3, coordinate.getZ(), 0);
	}

	@Test
	public void testToCartesian() {
		CartesianCoordinate coordinate = new CartesianCoordinate(1, 2, 3);

		CartesianCoordinate cartesian = coordinate.toCartesian();
		assertEquals(1, cartesian.getX(), 0);
		assertEquals(2, cartesian.getY(), 0);
		assertEquals(3, cartesian.getZ(), 0);
	}

	@Test
	public void testGetDistanceSamePoint() {
		CartesianCoordinate a = new CartesianCoordinate(11, 22, 33);
		CartesianCoordinate b = new CartesianCoordinate(11, 22, 33);

		assertEquals(0, a.getDistance(b), 0.0001);
	}

	@Test
	public void testGetDistanceX() {
		CartesianCoordinate a = new CartesianCoordinate(11, 22, 33);
		CartesianCoordinate b = new CartesianCoordinate(21, 22, 33);

		assertEquals(10, a.getDistance(b), 0.0001);
	}

	@Test
	public void testGetDistanceY() {
		CartesianCoordinate a = new CartesianCoordinate(11, 22, 33);
		CartesianCoordinate b = new CartesianCoordinate(11, 32, 33);

		assertEquals(10, a.getDistance(b), 0.0001);
	}

	@Test
	public void testGetDistanceZ() {
		CartesianCoordinate a = new CartesianCoordinate(11, 22, 33);
		CartesianCoordinate b = new CartesianCoordinate(11, 22, 43);

		assertEquals(10, a.getDistance(b), 0.0001);
	}

	@Test
	public void testGetDistanceDiagonal() {
		CartesianCoordinate a = new CartesianCoordinate(0, 0, 0);
		CartesianCoordinate b = new CartesianCoordinate(10, 10, 10);

		assertEquals(10 * Math.sqrt(3), a.getDistance(b), 0.0001);
	}

	@Test
	public void testGetDistanceRandom() {
		CartesianCoordinate a = new CartesianCoordinate(12, 34, 56);
		CartesianCoordinate b = new CartesianCoordinate(78, 910, 1112);

		assertEquals(1373, a.getDistance(b), 1);
	}
}