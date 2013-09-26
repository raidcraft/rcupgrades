package de.raidcraft.rcupgrades;

import de.raidcraft.rcupgrades.api.holder.UpgradeHolder;
import org.bukkit.configuration.ConfigurationSection;

/**
 * @author Philip Urban
 */
public class UpgradeManager {

    /**
     * Load and returns existing UpgradeHolder.
     *
     */
    public <O> UpgradeHolder<O> loadDatabaseUpgradeHolder(ConfigurationSection holderConfig, int id) {

        UpgradeHolder<O> upgradeHolder = new DatabaseUpgradeHolder<O>(holderConfig, id);
        return upgradeHolder;
    }

    /**
     * Creates a new UpgradeHolder from given holder configuration and stores them in the database.
     *
     */
    public <O> UpgradeHolder createDatabaseUpgradeHolder(ConfigurationSection holderConfig) {

        UpgradeHolder<O> upgradeHolder = new DatabaseUpgradeHolder<O>(holderConfig);
        upgradeHolder.save();
        return upgradeHolder;
    }
}
