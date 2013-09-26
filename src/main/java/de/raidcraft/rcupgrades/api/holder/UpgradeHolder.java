package de.raidcraft.rcupgrades.api.holder;

import de.raidcraft.rcupgrades.api.upgrade.Upgrade;

import java.util.List;

/**
 * @author Philip Urban
 */
public interface UpgradeHolder<T> {

    public int getId();

    public String getName();

    public String getDescription();

    public T getTargetObject();

    public Upgrade getUpgrade(String name);

    public List<Upgrade> getUpgrades();

    public void save();
}
