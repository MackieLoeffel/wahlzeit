package org.wahlzeit.model;

public class ArchitecturePhotoFactory extends PhotoFactory {

    private static ArchitecturePhotoFactory instance = new ArchitecturePhotoFactory();

    public static ArchitecturePhotoFactory getInstance() { return instance; }

    @Override
    public Photo createPhoto(PhotoId id) {
        return new ArchitecturePhoto(id);
    }
}
