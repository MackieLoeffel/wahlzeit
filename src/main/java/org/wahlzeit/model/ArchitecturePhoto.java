package org.wahlzeit.model;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Subclass;

import static org.wahlzeit.utils.AssertUtil.assertArgumentNotNull;

/**
 *	@PatternInstance:
 *   patternName = “Abstract Factory”
 *   participants = {
 *	   “AbstractFactory”, “ConcreteFactory”,
 *	   "AbstractProduct", "ConcreteProduct"
 *   }
 */
@Subclass(index = true)
@Entity
public class ArchitecturePhoto extends Photo {

    public ArchitecturePhoto() {}

    public ArchitecturePhoto(PhotoId id) {
        super(id);
        assertArgumentNotNull("id", id);
    }
}
