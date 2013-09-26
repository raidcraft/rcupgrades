package de.raidcraft.rcupgrades.api.level;

import java.util.List;

/**
 * @author Philip Urban
 */
public abstract class AbstractUpgradeLevel<T> implements UpgradeLevel<T> {

    private int number;
    private String name;
    private boolean unlocked;
    private List<String> requirementDescription;
    private List<String> rewardDescription;

    protected AbstractUpgradeLevel(int number, String name, boolean unlocked, List<String> requirementDescription, List<String> rewardDescription) {

        this.number = number;
        this.name = name;
        this.unlocked = unlocked;
        this.requirementDescription = requirementDescription;
        this.rewardDescription = rewardDescription;
    }

    @Override
    public int getNumber() {

        return number;
    }

    @Override
    public String getName() {

        return name;
    }

    @Override
    public List<String> getRequirementDescription() {

        return requirementDescription;
    }

    @Override
    public List<String> getRewardDescription() {

        return rewardDescription;
    }

    @Override
    public boolean isUnlocked() {

        return unlocked;
    }

    @Override
    public void setUnlocked(boolean unlocked) {

        this.unlocked = unlocked;
    }
}
