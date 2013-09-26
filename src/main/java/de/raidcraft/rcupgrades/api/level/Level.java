package de.raidcraft.rcupgrades.api.level;

import de.raidcraft.rcupgrades.api.unlockresult.UnlockResult;

import java.util.List;

/**
 * @author Philip Urban
 */
public interface Level<T> {

    public int getNumber();

    public String getName();

    public List<String> getRequirementDescription();

    public UnlockResult unlock(T object);
}
