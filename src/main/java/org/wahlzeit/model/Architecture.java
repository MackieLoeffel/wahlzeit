package org.wahlzeit.model;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import org.wahlzeit.services.DataObject;
import org.wahlzeit.utils.AssertUtil;

@Entity
public class Architecture extends DataObject /* binds CreationManager.Object, TypeHierarchy.Object, DomainInformation.Domain */ {
    private Coordinate location;
    private ArchitectureType type;

    @Id
    private Long id;

    // for objectify
    public Architecture() {}

    public Architecture(ArchitectureType type, Coordinate location) {
        AssertUtil.assertArgumentNotNull("type", type);
        AssertUtil.assertArgumentNotNull("location", location);
        this.location = location;
        this.type = type;
    }

    public Coordinate getLocation() {
        return location;
    }

    public void setLocation(Coordinate location) {
        this.location = location;
    }

    public ArchitectureType getType() {
        return type;
    }

    public void setType(ArchitectureType type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }
}
