package de.raidcraft.rcupgrades.api.action;

import org.bukkit.configuration.ConfigurationSection;

/**
 * @author Philip Urban
 */
public interface Reward<T> {

    public String getName();

    public void reward(T object, ConfigurationSection args);
}
