package org.wahlzeit.utils;

import org.junit.Test;

public class AssertUtilTest {

    @Test(expected = IllegalArgumentException.class)
    public void testArgumentNotNullFehler() {
        AssertUtil.assertArgumentNotNull("args", null);
    }

    @Test
    public void testArgumentNotNull() {
        AssertUtil.assertArgumentNotNull("args", new Object());
    }

    @Test
    public void testArgumentValidDoubleValid() {
        AssertUtil.assertArgumentValidDouble("arg", 1.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testArgumentValidDoubleNaN() {
        AssertUtil.assertArgumentValidDouble("arg", Double.NaN);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testArgumentValidDoublePosInf() {
        AssertUtil.assertArgumentValidDouble("arg", Double.POSITIVE_INFINITY);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testArgumentValidDoubleNegInf() {
        AssertUtil.assertArgumentValidDouble("arg", Double.NEGATIVE_INFINITY);
    }
}
