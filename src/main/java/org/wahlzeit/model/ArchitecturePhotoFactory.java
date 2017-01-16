package org.wahlzeit.model;

import static org.wahlzeit.utils.AssertUtil.assertArgumentNotNull;

/**
 *	@PatternInstance:
 *   patternName = “Abstract Factory”
 *   participants = {
 *	   “AbstractFactory”, “ConcreteFactory”,
 *	   "AbstractProduct", "ConcreteProduct"
 *   }
 */
public class ArchitecturePhotoFactory extends PhotoFactory {

    private static ArchitecturePhotoFactory instance = new ArchitecturePhotoFactory();

    public static ArchitecturePhotoFactory getInstance() { return instance; }

    @Override
    public Photo createPhoto(PhotoId id) {
        assertArgumentNotNull("id", id);
        // here we select, which Photo class corresponds to the factory
        // the instantiation of ArchitecturePhoto is in-code, because we
        // simply call new
        return new ArchitecturePhoto(id);
    }
}
