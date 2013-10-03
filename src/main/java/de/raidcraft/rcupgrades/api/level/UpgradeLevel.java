package de.raidcraft.rcupgrades.api.level;

import de.raidcraft.api.requirement.Requirement;
import de.raidcraft.api.requirement.RequirementResolver;
import de.raidcraft.api.reward.Reward;
import de.raidcraft.rcupgrades.api.holder.UpgradeHolder;
import de.raidcraft.rcupgrades.api.unlockresult.UnlockResult;

import java.util.List;

/**
 * @author Philip Urban
 */
public interface UpgradeLevel<T> extends RequirementResolver<T> {

    public UpgradeHolder<T> getUpgradeHolder();

    public String getId();

    public String getName();

    public int getLevel();

    public void setRequirements(List<Requirement<T>> requirements);

    public void setRewards(List<Reward<T>> rewards);

    public List<String> getRequirementDescription();

    public List<String> getRewardDescription();

    public boolean isUnlocked();

    public void setUnlocked(boolean unlocked);

    public UnlockResult tryToUnlock(T object);
}
