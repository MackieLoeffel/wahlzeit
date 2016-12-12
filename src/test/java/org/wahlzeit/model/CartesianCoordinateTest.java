package org.wahlzeit.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class CartesianCoordinateTest {

	@Test
	public void testConstructor() {
		CartesianCoordinate coordinate = CartesianCoordinate.create(1, 2, 3);

		assertEquals(1, coordinate.getX(), 0);
		assertEquals(2, coordinate.getY(), 0);
		assertEquals(3, coordinate.getZ(), 0);
	}

	@Test
	public void testToCartesian() {
		CartesianCoordinate coordinate = CartesianCoordinate.create(1, 2, 3);

		assertEquals(1, coordinate.asCartesianX(), 0);
		assertEquals(2, coordinate.asCartesianY(), 0);
		assertEquals(3, coordinate.asCartesianZ(), 0);
	}

	@Test
	public void testGetDistanceSamePoint() {
		CartesianCoordinate a = CartesianCoordinate.create(11, 22, 33);
		CartesianCoordinate b = CartesianCoordinate.create(11, 22, 33);

		assertEquals(0, a.getDistance(b), 0.0001);
	}

	@Test
	public void testGetDistanceX() {
		CartesianCoordinate a = CartesianCoordinate.create(11, 22, 33);
		CartesianCoordinate b = CartesianCoordinate.create(21, 22, 33);

		assertEquals(10, a.getDistance(b), 0.0001);
	}

	@Test
	public void testGetDistanceY() {
		CartesianCoordinate a = CartesianCoordinate.create(11, 22, 33);
		CartesianCoordinate b = CartesianCoordinate.create(11, 32, 33);

		assertEquals(10, a.getDistance(b), 0.0001);
	}

	@Test
	public void testGetDistanceZ() {
		CartesianCoordinate a = CartesianCoordinate.create(11, 22, 33);
		CartesianCoordinate b = CartesianCoordinate.create(11, 22, 43);

		assertEquals(10, a.getDistance(b), 0.0001);
	}

	@Test
	public void testGetDistanceDiagonal() {
		CartesianCoordinate a = CartesianCoordinate.create(0, 0, 0);
		CartesianCoordinate b = CartesianCoordinate.create(10, 10, 10);

		assertEquals(10 * Math.sqrt(3), a.getDistance(b), 0.0001);
	}

	@Test
	public void testGetDistanceRandom() {
		CartesianCoordinate a = CartesianCoordinate.create(12, 34, 56);
		CartesianCoordinate b = CartesianCoordinate.create(78, 910, 1112);

		assertEquals(1373, a.getDistance(b), 1);
	}

	@Test
	public void testIsEqual() {
		CartesianCoordinate a = CartesianCoordinate.create(1, 2, 3);
		CartesianCoordinate b = CartesianCoordinate.create(1, 2, 3);

		assertTrue(a.isEqual(b));
	}

	@Test
	public void testIsEqualFalse() {
		CartesianCoordinate a = CartesianCoordinate.create(1, 2, 3);
		CartesianCoordinate b = CartesianCoordinate.create(1, 2, 2.5);

		assertFalse(a.isEqual(b));
	}

	@Test
	public void testEquals() {
		CartesianCoordinate a = CartesianCoordinate.create(1, 2, 3);
		CartesianCoordinate b = CartesianCoordinate.create(1, 2, 3);

		assertTrue(a.equals(b));
	}

	@Test
	public void testEqualsOperator() {
		CartesianCoordinate a = CartesianCoordinate.create(1, 2, 3);
		CartesianCoordinate b = CartesianCoordinate.create(1, 2, 3);

		assertTrue(a == b);
	}

	@Test
	public void testEqualsFailed() {
		CartesianCoordinate a = CartesianCoordinate.create(1, 2, 4);
		CartesianCoordinate b = CartesianCoordinate.create(1, 2, 3);

		assertFalse(a.equals(b));
	}

	@Test
	public void testHashCode() {
		CartesianCoordinate a = CartesianCoordinate.create(1, 2, 3);
		CartesianCoordinate b = CartesianCoordinate.create(1, 2, 3);

		assertEquals(a.hashCode(), b.hashCode());
	}
}
