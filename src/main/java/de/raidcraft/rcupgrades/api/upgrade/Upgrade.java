package de.raidcraft.rcupgrades.api.upgrade;

import de.raidcraft.rcupgrades.api.level.UpgradeLevel;

import java.util.List;

/**
 * @author Philip Urban
 */
public interface Upgrade {

    String getId();

    String getName();

    String getDescription();

    UpgradeLevel getLowestLockedLevel();

    UpgradeLevel getHighestUnlockedLevel();

    void setLevels(List<UpgradeLevel> levels);

    void addLevel(UpgradeLevel level);

    UpgradeLevel getLevel(String id);

    UpgradeLevel getLevel(int level);

    List<UpgradeLevel> getLevels();
}
