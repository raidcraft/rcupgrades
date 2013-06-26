package de.raidcraft.rcupgrades.api.upgrade;

import org.bukkit.configuration.ConfigurationSection;

/**
 * @author Philip Urban
 */
public interface Upgrade extends ConfigurationSection {

    public int getAvailableLevels();

    public int getCurrentLevel();

    public void increaseLevel();

    public void decreaseLevel();

    public void setLevel(int level);
}
