package de.raidcraft.rcupgrades;

import de.raidcraft.api.BasePlugin;
import de.raidcraft.rcupgrades.tables.TUpgrade;
import de.raidcraft.rcupgrades.tables.TUpgradeLevel;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Philip Urban
 */
public class RCUpgradesPlugin extends BasePlugin {

    @Override
    public void enable() {

    }

    @Override
    public void disable() {
    }

    @Override
    public List<Class<?>> getDatabaseClasses() {

        List<Class<?>> databases = new ArrayList<>();
        databases.add(TUpgrade.class);
        databases.add(TUpgradeLevel.class);
        return databases;
    }
}
