package de.raidcraft.rcupgrades;

import de.raidcraft.rcupgrades.api.holder.ConfigurationUpgradeHolder;
import org.bukkit.configuration.ConfigurationSection;

/**
 * @author Philip Urban
 */
public class DatabaseUpgradeHolder<T> extends ConfigurationUpgradeHolder<T> {

    public DatabaseUpgradeHolder(ConfigurationSection config) {

        super(config);
    }

    public DatabaseUpgradeHolder(ConfigurationSection config, int id) {

        super(config);
        this.id = id;
        load();
    }

    @Override
    public void save() {

        // save new
        if(id == 0) {

        }
        // update
        else {

        }
        //TODO: implement
    }

    private void load() {

        if(id == 0) return;

        //TODO: implement
    }
}
