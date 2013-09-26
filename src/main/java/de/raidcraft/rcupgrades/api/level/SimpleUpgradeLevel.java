package de.raidcraft.rcupgrades.api.level;

import de.raidcraft.api.requirement.Requirement;
import de.raidcraft.rcupgrades.api.unlockresult.UnlockResult;

import java.util.List;

/**
 * @author Philip Urban
 */
public class SimpleUpgradeLevel<T> extends AbstractUpgradeLevel<T> {

    private List<Requirement<T>> requirements;

    public SimpleUpgradeLevel(int number, String name, boolean unlocked, List<String> requirementDescription, List<String> rewardDescription, List<Requirement<T>> requirements) {

        super(number, name, unlocked, requirementDescription, rewardDescription);
        this.requirements = requirements;
    }

    @Override
    public UnlockResult tryToUnlock(T object) {

        UnlockResult unlockResult = new UnlockResult();

        for(Requirement<T> requirement : requirements) {

            if(!requirement.isMet(object)) {
                unlockResult.setSuccessful(false);
                unlockResult.setShortReason(requirement.getShortReason());
                unlockResult.setLongReason(requirement.getLongReason());
                return unlockResult;
            }
        }

        unlockResult.setSuccessful(true);
        return unlockResult;
    }
}
