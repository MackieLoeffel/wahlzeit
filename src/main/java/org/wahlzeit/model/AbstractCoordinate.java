package org.wahlzeit.model;

import static org.wahlzeit.utils.AssertUtil.assertArgumentNotNull;

public abstract class AbstractCoordinate implements Coordinate {
    public static final double EPSILON = 0.0000001;

    @Override
    public boolean isEqual(Coordinate other) {
        assertArgumentNotNull("other", other);
        return Math.abs(getDistance(other)) < EPSILON;
    }

    /**
     *	@PatternInstance:
     *   patternName = “TemplateMethod”
     *   participants = {
     *	   “TemplateMethod”, “Step”
     *   }
     */
    @Override
    public double getDistance(Coordinate other) {
        assertArgumentNotNull("other", other);
        double dx = asCartesianX() - other.asCartesianX();
        double dy = asCartesianY() - other.asCartesianY();
        double dz = asCartesianZ() - other.asCartesianZ();
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }
}
