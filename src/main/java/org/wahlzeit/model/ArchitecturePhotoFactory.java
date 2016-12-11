package org.wahlzeit.model;

import static org.wahlzeit.utils.AssertUtil.assertArgumentNotNull;

public class ArchitecturePhotoFactory extends PhotoFactory {

    private static ArchitecturePhotoFactory instance = new ArchitecturePhotoFactory();

    public static ArchitecturePhotoFactory getInstance() { return instance; }

    @Override
    public Photo createPhoto(PhotoId id) {
        assertArgumentNotNull("id", id);
        return new ArchitecturePhoto(id);
    }
}
