package org.wahlzeit.model;

public class ArchitecturePhotoManager extends PhotoManager {

    private final static ArchitecturePhotoManager instance = new ArchitecturePhotoManager();

    protected ArchitecturePhotoManager() {
        super(ArchitecturePhotoFactory.getInstance());
    }

    public static ArchitecturePhotoManager getInstance() { return instance; }
}
