package org.wahlzeit.model;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Subclass;

@Subclass(index = true)
@Entity
public class ArchitecturePhoto extends Photo {

    public ArchitecturePhoto() {}

    public ArchitecturePhoto(PhotoId id) {
        super(id);
    }
}
