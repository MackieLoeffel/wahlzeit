package org.wahlzeit.model;

import com.googlecode.objectify.Ref;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import org.wahlzeit.services.DataObject;
import org.wahlzeit.utils.AssertUtil;

/**
 * A type of architecture, which may have been built
 * multiple times (the Architecture objects)
 */
@Entity
public class ArchitectureType extends DataObject {
    @Id private String name;
    private String architectName;
    private Ref<ArchitectureType> supertype;

    // for objectify
    public ArchitectureType() {}

    public ArchitectureType(String name, String architectName, ArchitectureType supertype) {
        AssertUtil.assertArgumentNotNull("name", name);
        this.name = name;
        this.architectName = architectName;

        if(supertype != null) {
            this.supertype = Ref.create(supertype);
        }
    }

    public String getName() {
        return name;
    }

    public String getArchitectName() {
        return architectName;
    }

    public void setArchitectName(String architectName) {
        this.architectName = architectName;
    }

    public ArchitectureType getSupertype() {
        if(supertype == null) {
            return null;
        }
        return supertype.get();
    }

    public boolean isSubtype(ArchitectureType supertype) {
        AssertUtil.assertArgumentNotNull("supertype", supertype);
        if (getSupertype() == supertype) {
            return true;
        }
        if (getSupertype() == null) {
           return false;
        }
        return getSupertype().isSubtype(supertype);
    }
}
