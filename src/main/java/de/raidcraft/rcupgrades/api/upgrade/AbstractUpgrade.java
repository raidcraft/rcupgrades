package de.raidcraft.rcupgrades.api.upgrade;

/**
 * @author Philip Urban
 */
public abstract class AbstractUpgrade<T> implements Upgrade<T> {

    private String id;
    private String name;
    private String description;

    protected AbstractUpgrade(String id, String name, String description) {

        this.id = id;
        this.name = name;
        this.description = description;
    }

    @Override
    public String getName() {

        return name;
    }

    @Override
    public String getDescription() {

        return description;
    }

    @Override
    public String getId() {

        return id;
    }
}
