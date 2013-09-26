package de.raidcraft.rcupgrades.api.upgrade;

import de.raidcraft.rcupgrades.api.level.Level;

import java.util.List;

/**
 * @author Philip Urban
 */
public interface Upgrade<T> {

    public String getName();

    public String getDescription();

    public Level<T> getHighestLockedLevel();

    public Level<T> getLevel(int level);

    public List<Level<T>> getLevels();
}
