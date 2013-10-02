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
    private T object;

    protected AbstractUpgradeLevel(T object, int number, String name, boolean unlocked, List<String> requirementDescription, List<String> rewardDescription) {

        this.object = object;
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

    @Override
    public T getObject() {

        return object;
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
