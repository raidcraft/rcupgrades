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
    protected Map<String, Upgrade<T>> upgrades = new CaseInsensitiveMap<>();

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
    public Upgrade<T> getUpgrade(String name) {

        return upgrades.get(name);
    }

    @Override
    public List<Upgrade<T>> getUpgrades() {

        if(upgrades.values() == null || upgrades.values().size() == 0) {
            return new ArrayList<>();
        }
        return new ArrayList<>(upgrades.values());
    }
}
