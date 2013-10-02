package de.raidcraft.rcupgrades.api.level;

import de.raidcraft.api.requirement.Requirement;
import de.raidcraft.api.reward.Reward;
import de.raidcraft.rcupgrades.api.holder.UpgradeHolder;
import de.raidcraft.rcupgrades.api.unlockresult.UnlockResult;

import java.util.List;

/**
 * @author Philip Urban
 */
public class SimpleUpgradeLevel<T> extends AbstractUpgradeLevel<T> {

    private List<Requirement<T>> requirements;
    private List<Reward<T>> rewards;
    private UnlockResult unlockResult;

    public SimpleUpgradeLevel(UpgradeHolder<T> upgradeHolder, int number, String name, List<String> requirementDescription, List<String> rewardDescription) {

        super(upgradeHolder, number, name, false, requirementDescription, rewardDescription);
        this.unlockResult = new UnlockResult();
    }

    @Override
    public void setRequirements(List<Requirement<T>> requirements) {

        this.requirements = requirements;
    }

    @Override
    public void setRewards(List<Reward<T>> rewards) {

        this.rewards = rewards;
    }

    @Override
    public List<Requirement<T>> getRequirements() {

        return requirements;
    }

    @Override
    public boolean isMeetingAllRequirements(T object) {

        for(Requirement<T> requirement : requirements) {

            if(!requirement.isMet(object)) {
                unlockResult.setSuccessful(false);
                unlockResult.setShortReason(requirement.getShortReason());
                unlockResult.setLongReason(requirement.getLongReason());
                return false;
            }
        }
        unlockResult.setSuccessful(true);
        unlockResult.clearReasons();
        return true;
    }

    @Override
    public String getResolveReason(T object) {

        return unlockResult.getLongReason();
    }

    @Override
    public UnlockResult tryToUnlock(T object) {

        if(isMeetingAllRequirements(object)) {
            // reward
            for(Reward reward : rewards) {
                reward.reward(getObject());
            }
            // save
            setUnlocked(true);
            getUpgradeHolder().save();
        }
        return unlockResult;
    }
}
