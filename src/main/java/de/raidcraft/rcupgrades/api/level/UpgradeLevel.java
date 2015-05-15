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

    UpgradeHolder<T> getUpgradeHolder();

    String getId();

    String getName();

    int getLevel();

    boolean isStored();

    void setRequirements(List<Requirement<T>> requirements);

    void setRewards(List<Reward<T>> rewards);

    List<String> getRequirementDescription();

    List<String> getRewardDescription();

    boolean isUnlocked();

    void setUnlocked(boolean unlocked);

    UnlockResult tryToUnlock(T object);
}
