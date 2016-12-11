package org.wahlzeit.utils;

public class AssertUtil {
    private AssertUtil() {}

    public static void assertArgumentNotNull(String argName, Object o) {
        if(o == null) {
            throw new IllegalArgumentException("Argument " + argName + "  may not be null");
        }
    }

    public static void assertArgumentValidDouble(String argname, double d) {
        if(Double.isInfinite(d) || Double.isNaN(d)) {
            throw new IllegalArgumentException(argname + "must be a normal double");
        }
    }
}
