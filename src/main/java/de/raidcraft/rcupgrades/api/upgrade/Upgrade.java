package de.raidcraft.rcupgrades.api.upgrade;

import org.bukkit.configuration.ConfigurationSection;

/**
 * @author Philip Urban
 */
public interface Upgrade extends ConfigurationSection {

    public String getName();

    public String getFriendlyName();

    public void setFriendlyName(String friendlyName);

    public String getDescription();

    public void setDescription(String description);

    public void setMaxLevel(int maxLevel);

    public int getMaxLevel();

    public int getCurrentLevel();

    public void increaseLevel();

    public void decreaseLevel();

    public void setLevel(int level);
}
