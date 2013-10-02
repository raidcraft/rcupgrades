package de.raidcraft.rcupgrades.api.level;

import de.raidcraft.rcupgrades.api.holder.UpgradeHolder;

import java.util.List;

/**
 * @author Philip Urban
 */
public abstract class AbstractUpgradeLevel<T> implements UpgradeLevel<T> {

    private UpgradeHolder<T> upgradeHolder;
    private int number;
    private String name;
    private boolean unlocked;
    private List<String> requirementDescription;
    private List<String> rewardDescription;

    protected AbstractUpgradeLevel(UpgradeHolder<T> upgradeHolder, int number, String name, boolean unlocked, List<String> requirementDescription, List<String> rewardDescription) {

        this.upgradeHolder = upgradeHolder;
        this.number = number;
        this.name = name;
        this.unlocked = unlocked;
        this.requirementDescription = requirementDescription;
        this.rewardDescription = rewardDescription;
    }

    @Override
    public UpgradeHolder<T> getUpgradeHolder() {

        return upgradeHolder;
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

    @Override
    public T getObject() {

        return upgradeHolder.getObject();
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbstractUpgradeLevel that = (AbstractUpgradeLevel) o;

        if (number != that.number) return false;
        if (!name.equals(that.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {

        int result = number;
        result = 31 * result + name.hashCode();
        return result;
    }
}
