package de.raidcraft.rcupgrades.api.level;

import de.raidcraft.RaidCraft;
import de.raidcraft.api.action.requirement.ReasonableRequirement;
import de.raidcraft.api.action.requirement.Requirement;
import de.raidcraft.api.reward.Reward;
import de.raidcraft.rcupgrades.api.holder.UpgradeHolder;
import de.raidcraft.rcupgrades.api.unlockresult.UnlockResult;
import de.raidcraft.rcupgrades.events.UpgradeUnlockEvent;

import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author Philip Urban
 */
public class SimpleUpgradeLevel<T> extends AbstractUpgradeLevel<T> {

    private Collection<Requirement<T>> requirements;
    private List<Reward<T>> rewards;
    private UnlockResult unlockResult;

    public SimpleUpgradeLevel(UpgradeHolder<T> upgradeHolder, String id, int level, String name, boolean stored, List<String> requirementDescription, List<String> rewardDescription) {

        super(upgradeHolder, id, level, name, stored, false, requirementDescription, rewardDescription);
        this.unlockResult = new UnlockResult();
    }

    @Override
    public void setRequirements(Collection<Requirement<T>> requirements) {

        this.requirements = requirements;

        for(Requirement req: requirements) {
            if(!req.getDescription(null).isPresent()) continue;
            addRequirementDescription((String)req.getDescription(null).get());
        }
    }



    @Override
    public void setRewards(List<Reward<T>> rewards) {

        this.rewards = rewards;

        for(Reward reward : rewards) {
            if(reward.getDescription() == null || reward.getDescription().isEmpty()) continue;
            addRewardDescription(reward.getDescription());
        }
    }

    @Override
    public <T> boolean isMeetingAllRequirements(T object) {

        for(Requirement requirement : requirements) {

            if(!requirement.test(object)) {
                unlockResult.setSuccessful(false);
                if(requirement instanceof ReasonableRequirement)
                    unlockResult.setLongReason(((ReasonableRequirement) requirement).getReason(object));
                return false;
            }
        }
        unlockResult.setSuccessful(true);
        unlockResult.clearReasons();
        return true;
    }

    @Override
    public UnlockResult tryToUnlock(T object) {

        if (isMeetingAllRequirements(object)) {

            UpgradeUnlockEvent event = new UpgradeUnlockEvent(this, unlockResult, object);
            RaidCraft.callEvent(event);
            if (event.isCancelled()) {
                unlockResult.setSuccessful(false);
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

    @Override
    public Collection<Requirement<?>> getRequirements() {
        return null;
    }

    @Override
    public <T> Collection<Requirement<T>> getRequirements(Class<?> entityClazz) {
        return null;
    }

    @Override
    public <T> Collection<Requirement<T>> getRequirements(Class<T> entityClazz, Predicate<? super Requirement<T>> filter) {
        return null;
    }
}
