package de.raidcraft.rcupgrades.api.holder;

import de.raidcraft.rcupgrades.api.upgrade.Upgrade;
import org.bukkit.configuration.ConfigurationSection;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Philip Urban
 */
public abstract class AbstractHolder implements Holder {

    private String name;
    private List<Upgrade> upgrades = new ArrayList<>();

    protected AbstractHolder(ConfigurationSection config) {

    }

    @Override
    public List<Upgrade> getUpgrades() {

        return upgrades;
    }

    @Override
    public String getName() {

        return name;
    }
}
