package de.raidcraft.rcupgrades.api.holder;

import de.raidcraft.rcupgrades.api.upgrade.Upgrade;
import de.raidcraft.util.CaseInsensitiveMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Philip Urban
 */
public abstract class AbstractUpgradeHolder<T> implements UpgradeHolder<T> {

    protected int id;
    protected String name;
    protected String description;
    protected T object;
    protected Map<String, Upgrade> upgrades = new CaseInsensitiveMap<>();

    @Override
    public int getId() {

        return id;
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
    public T getObject() {
        return object;
    }

    @Override
    public Upgrade getUpgrade(String id) {

        return upgrades.get(id);
    }

    @Override
    public List<Upgrade> getUpgrades() {

        if(upgrades.values() == null || upgrades.values().size() == 0) {
            return new ArrayList<>();
        }
        return new ArrayList<>(upgrades.values());
    }
}
