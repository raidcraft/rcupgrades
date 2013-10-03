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

    public UpgradeLevel getHighestUnlockedLevel();

    public void setLevels(List<UpgradeLevel> levels);

    public void addLevel(UpgradeLevel level);

    public UpgradeLevel getLevel(String id);

    public List<UpgradeLevel> getLevels();
}
