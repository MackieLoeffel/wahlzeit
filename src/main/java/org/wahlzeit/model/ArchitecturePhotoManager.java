package org.wahlzeit.model;

/**
 *	@PatternInstance:
 *   patternName = “Singleton”
 *   participants = {
 *	   “Singleton”
 *   }
 */
public class ArchitecturePhotoManager extends PhotoManager<ArchitecturePhoto> {

    private final static ArchitecturePhotoManager instance = new ArchitecturePhotoManager();

    protected ArchitecturePhotoManager() {
        // here is the (first part of) the selection, which Photo we use in this PhotoManager
        // the second part is in the creation method in ArchitecturePhotoFactory
        super(ArchitecturePhotoFactory.getInstance(), ArchitecturePhoto.class);
    }

    public static ArchitecturePhotoManager getInstance() { return instance; }
}
