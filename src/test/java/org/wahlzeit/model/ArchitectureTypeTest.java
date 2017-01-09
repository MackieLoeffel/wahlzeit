package org.wahlzeit.model;

import org.junit.Before;
import org.junit.Test;
import org.wahlzeit.services.OfyService;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ArchitectureTypeTest {

    @Before
    public void init() {
        OfyService.factory();
    }

    @Test(expected = IllegalArgumentException.class)
    public void isSubtypeFail() {
        ArchitectureType type = new ArchitectureType("house", "peter", null);
        type.isSubtype(null);
    }

    @Test
    public void isSubtypeFalse() {
        ArchitectureType type = new ArchitectureType("house", "peter", null);
        ArchitectureType destType = new ArchitectureType("bridge", null, null);
        assertFalse(type.isSubtype(destType));
    }

    @Test
    public void isSubtypeDirect() {
        ArchitectureType house = new ArchitectureType("house", null, null);
        ArchitectureType myhouse = new ArchitectureType("myhouse", "me", house);
        assertTrue(myhouse.isSubtype(house));
    }

    @Test
    public void isSubtypeIndirect() {
        ArchitectureType house = new ArchitectureType("house", null, null);
        ArchitectureType bighouse = new ArchitectureType("bighouse", "hans", house);
        ArchitectureType myhouse = new ArchitectureType("myhouse", "me", bighouse);
        assertTrue(myhouse.isSubtype(house));
    }
}
