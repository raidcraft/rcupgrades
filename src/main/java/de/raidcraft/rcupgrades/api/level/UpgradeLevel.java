package de.raidcraft.rcupgrades.api.level;

import de.raidcraft.rcupgrades.api.unlockresult.UnlockResult;

import java.util.List;

/**
 * @author Philip Urban
 */
public interface UpgradeLevel<T> {

    public int getNumber();

    public String getName();

    public List<String> getRequirementDescription();

    public List<String> getRewardDescription();

    public boolean isUnlocked();

    public void setUnlocked(boolean unlocked);

    public UnlockResult tryToUnlock(T object);
}
