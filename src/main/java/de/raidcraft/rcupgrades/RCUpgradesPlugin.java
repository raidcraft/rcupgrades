package de.raidcraft.rcupgrades;

import de.raidcraft.api.BasePlugin;

/**
 * @author Philip Urban
 */
public class RCUpgradesPlugin extends BasePlugin {

    private UpgradeObjectManager upgradeObjectManager;

    @Override
    public void enable() {

        upgradeObjectManager = new UpgradeObjectManager(this);
    }

    @Override
    public void disable() {
    }

    public UpgradeObjectManager getUpgradeObjectManager() {

        return upgradeObjectManager;
    }
}
