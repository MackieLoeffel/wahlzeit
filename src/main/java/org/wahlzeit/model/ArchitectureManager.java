package org.wahlzeit.model;

import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.Work;
import org.wahlzeit.services.LogBuilder;
import org.wahlzeit.services.ObjectManager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.logging.Logger;

public class ArchitectureManager extends ObjectManager {
    private static final Logger log = Logger.getLogger(ArchitectureManager.class.getName());

    public static final ArchitectureManager instance = new ArchitectureManager();

    private ArchitectureManager() {}

    public static ArchitectureManager getInstance() {
        return instance;
    }

    public void init() {
        loadAll();
    }

    private HashMap<Long, Architecture> architectures = new HashMap<>();
    private HashMap<String, ArchitectureType> architectureTypes = new HashMap<>();

    public Architecture createArchitecture(ArchitectureType type, Coordinate location) {
        Architecture arch = new Architecture(type, location);
        updateObject(arch);
        addArchitectureToCache(arch);
        return arch;
    }

    public ArchitectureType createArchitectureType(String name, String architectName, ArchitectureType supertype) {
        if (existsArchitectureType(name)) {
            throw new IllegalArgumentException("ArchitectureType with name " + name + " already exists");
        }
        ArchitectureType type = new ArchitectureType(name, architectName, supertype);
        updateObject(type);
        addArchitectureTypeToCache(type);
        return type;
    }

    public void loadAll() {
        Collection<ArchitectureType> loadedArchitectureTypes = ObjectifyService.run(new Work<Collection<ArchitectureType>>() {
            @Override
            public Collection<ArchitectureType> run() {
                Collection<ArchitectureType> loadedArchitectureTypes = new ArrayList<>();
                readObjects(loadedArchitectureTypes, ArchitectureType.class);
                return loadedArchitectureTypes;
            }
        });

        for(ArchitectureType type : loadedArchitectureTypes) {
            addArchitectureTypeToCache(type);
        }
        log.info(LogBuilder.createSystemMessage().addMessage(loadedArchitectureTypes.size() + "ArchitecturTypes loaded.").toString());

        Collection<Architecture> loadedArchitectures = ObjectifyService.run(new Work<Collection<Architecture>>() {
            @Override
            public Collection<Architecture> run() {
                Collection<Architecture> loadedArchitectures = new ArrayList<>();
                readObjects(loadedArchitectures, Architecture.class);
                return loadedArchitectures;
            }
        });

        for(Architecture arch : loadedArchitectures) {
            addArchitectureToCache(arch);
        }
        log.info(LogBuilder.createSystemMessage().addMessage(loadedArchitectures.size() + "Architectures loaded.").toString());
    }

    public boolean existsArchitectureType(String name) {
        return architectureTypes.containsKey(name);
    }

    private void addArchitectureToCache(Architecture arch) {
        architectures.put(arch.getId(), arch);
    }

    private void addArchitectureTypeToCache(ArchitectureType type) {
        architectureTypes.put(type.getName(), type);
    }
}
