package org.wahlzeit.model;

import com.googlecode.objectify.annotation.Entity;

@Entity
public class ArchitecturePhoto extends Photo {

    public ArchitecturePhoto() {}

    public ArchitecturePhoto(PhotoId id) {
        super(id);
    }
}
