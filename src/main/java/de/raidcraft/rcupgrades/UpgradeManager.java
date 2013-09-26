package de.raidcraft.rcupgrades;

import de.raidcraft.RaidCraft;
import de.raidcraft.rcupgrades.api.holder.UpgradeHolder;
import de.raidcraft.rcupgrades.tables.TUpgradeHolder;
import org.bukkit.configuration.ConfigurationSection;

/**
 * @author Philip Urban
 */
public class UpgradeManager {

    /**
     * Load and returns existing UpgradeHolder.
     *
     */
    public <O> UpgradeHolder<O> loadDatabaseUpgradeHolder(O object, ConfigurationSection holderConfig, int id) {

        UpgradeHolder<O> upgradeHolder = new DatabaseUpgradeHolder<O>(object, holderConfig, id);
        return upgradeHolder;
    }

    /**
     * Creates a new UpgradeHolder from given holder configuration and stores them in the database.
     *
     */
    public <O> UpgradeHolder createDatabaseUpgradeHolder(O object, ConfigurationSection holderConfig) {

        UpgradeHolder<O> upgradeHolder = new DatabaseUpgradeHolder<O>(object, holderConfig);
        upgradeHolder.save();
        return upgradeHolder;
    }

    public void deleteUpgradeHolder(int id) {

        TUpgradeHolder tUpgradeHolder = RaidCraft.getDatabase(RCUpgradesPlugin.class).find(TUpgradeHolder.class, id);
        RaidCraft.getDatabase(RCUpgradesPlugin.class).delete(tUpgradeHolder);
    }
}
