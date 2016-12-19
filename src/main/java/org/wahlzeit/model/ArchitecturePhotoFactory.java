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
        return new ArchitecturePhoto(id);
    }
}
