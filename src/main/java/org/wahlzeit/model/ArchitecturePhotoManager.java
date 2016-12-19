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
        super(ArchitecturePhotoFactory.getInstance(), ArchitecturePhoto.class);
    }

    public static ArchitecturePhotoManager getInstance() { return instance; }
}
