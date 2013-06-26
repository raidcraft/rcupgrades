package de.raidcraft.rcupgrades.api.holder;

import org.bukkit.configuration.ConfigurationSection;

/**
 * @author Philip Urban
 */
public class SQLHolder extends AbstractHolder {

    int id;

    public SQLHolder(int id, ConfigurationSection config) {

        // TODO load holder from database, set saved upgrades an levels. Create new if saved holder couldn't found.
        super(config);
    }

    private SQLHolder(ConfigurationSection config) {

        super(config);
    }

    @Override
    public int getId() {

        return id;
    }
}
