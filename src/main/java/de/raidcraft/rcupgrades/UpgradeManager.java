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
}
