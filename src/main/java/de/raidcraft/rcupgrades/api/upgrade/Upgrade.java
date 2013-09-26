package de.raidcraft.rcupgrades.api.upgrade;

import de.raidcraft.rcupgrades.api.level.UpgradeLevel;

import java.util.List;

/**
 * @author Philip Urban
 */
public interface Upgrade<T> {

    public String getName();

    public String getDescription();

    public UpgradeLevel<T> getHighestLockedLevel();

    public UpgradeLevel<T> getLevel(int level);

    public List<UpgradeLevel<T>> getLevels();
}
