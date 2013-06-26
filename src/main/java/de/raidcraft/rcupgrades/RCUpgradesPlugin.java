package de.raidcraft.rcupgrades;

import de.raidcraft.api.BasePlugin;
import de.raidcraft.rcupgrades.holder.HolderManager;
import de.raidcraft.rcupgrades.tables.THolder;
import de.raidcraft.rcupgrades.tables.TUpgrade;
import de.raidcraft.rcupgrades.upgrade.UpgradeManager;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Philip Urban
 */
public class RCUpgradesPlugin extends BasePlugin {

    private HolderManager holderManager;
    private UpgradeManager upgradeManager;

    @Override
    public void enable() {

        holderManager = new HolderManager(this);
        upgradeManager = new UpgradeManager(this);
    }

    @Override
    public void disable() {
    }

    @Override
    public List<Class<?>> getDatabaseClasses() {

        List<Class<?>> databases = new ArrayList<>();
        databases.add(THolder.class);
        databases.add(TUpgrade.class);
        return databases;
    }

    public HolderManager getHolderManager() {

        return holderManager;
    }

    public UpgradeManager getUpgradeManager() {

        return upgradeManager;
    }
}
