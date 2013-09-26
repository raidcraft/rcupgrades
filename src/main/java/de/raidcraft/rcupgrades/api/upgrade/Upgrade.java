package de.raidcraft.rcupgrades.api.upgrade;

import de.raidcraft.rcupgrades.api.level.UpgradeLevel;

import java.util.List;

/**
 * @author Philip Urban
 */
public interface Upgrade {

    public String getId();

    public String getName();

    public String getDescription();

    public UpgradeLevel getHighestLockedLevel();

    public UpgradeLevel getLevel(int level);

    public List<UpgradeLevel> getLevels();
}
