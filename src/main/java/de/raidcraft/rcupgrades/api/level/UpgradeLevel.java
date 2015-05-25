package de.raidcraft.rcupgrades.api.level;


import de.raidcraft.api.action.requirement.ReasonableRequirement;
import de.raidcraft.api.action.requirement.Requirement;
import de.raidcraft.api.action.requirement.RequirementHolder;
import de.raidcraft.api.reward.Reward;
import de.raidcraft.rcupgrades.api.holder.UpgradeHolder;
import de.raidcraft.rcupgrades.api.unlockresult.UnlockResult;

import java.util.Collection;
import java.util.List;

/**
 * @author Philip Urban
 */
public interface UpgradeLevel<T> extends RequirementHolder {

    UpgradeHolder<T> getUpgradeHolder();

    String getId();

    String getName();

    int getLevel();

    boolean isStored();

    void setRequirements(Collection<Requirement<T>> requirements);

    void setRewards(List<Reward<T>> rewards);

    List<String> getRequirementDescription();

    List<String> getRewardDescription();

    boolean isUnlocked();

    void setUnlocked(boolean unlocked);

    UnlockResult tryToUnlock(T object);
}
