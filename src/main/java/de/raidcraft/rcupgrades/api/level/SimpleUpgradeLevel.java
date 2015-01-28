package de.raidcraft.rcupgrades.api.level;

import de.raidcraft.RaidCraft;
import de.raidcraft.api.requirement.Requirement;
import de.raidcraft.api.reward.Reward;
import de.raidcraft.rcupgrades.api.holder.UpgradeHolder;
import de.raidcraft.rcupgrades.api.unlockresult.UnlockResult;
import de.raidcraft.rcupgrades.events.UpgradeUnlockEvent;

import java.util.List;

/**
 * @author Philip Urban
 */
public class SimpleUpgradeLevel<T> extends AbstractUpgradeLevel<T> {

    private List<Requirement<T>> requirements;
    private List<Reward<T>> rewards;
    private UnlockResult unlockResult;

    public SimpleUpgradeLevel(UpgradeHolder<T> upgradeHolder, String id, int level, String name, boolean stored, List<String> requirementDescription, List<String> rewardDescription) {

        super(upgradeHolder, id, level, name, stored, false, requirementDescription, rewardDescription);
        this.unlockResult = new UnlockResult();
    }

    @Override
    public void setRequirements(List<Requirement<T>> requirements) {

        this.requirements = requirements;

        for (Requirement req : requirements) {
            if (req.getDescription() == null || req.getDescription().isEmpty()) continue;
            addRequirementDescription(req.getDescription());
        }
    }

    @Override
    public void setRewards(List<Reward<T>> rewards) {

        this.rewards = rewards;

        for (Reward reward : rewards) {
            if (reward.getDescription() == null || reward.getDescription().isEmpty()) continue;
            addRewardDescription(reward.getDescription());
        }
    }

    @Override
    public List<Requirement<T>> getRequirements() {

        return requirements;
    }

    @Override
    public boolean isMeetingAllRequirements(T object) {

        for (Requirement<T> requirement : requirements) {

            if (!requirement.isMet(object)) {
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

        if (isMeetingAllRequirements(object)) {

            UpgradeUnlockEvent event = new UpgradeUnlockEvent(this, unlockResult, object);
            RaidCraft.callEvent(event);
            if (event.isCancelled()) {
                unlockResult.setSuccessful(false);
                unlockResult.setShortReason("Unlock event cancelled");
                unlockResult.setLongReason("Unlock was cancelled by plugin!");
                return unlockResult;
            }

            // reward
            for (Reward reward : rewards) {
                reward.reward(object);
            }
            // save
            setUnlocked(true);
            getUpgradeHolder().save();
        }
        return unlockResult;
    }
}
