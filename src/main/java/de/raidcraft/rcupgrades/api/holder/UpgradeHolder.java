package de.raidcraft.rcupgrades.api.holder;

import de.raidcraft.rcupgrades.api.upgrade.Upgrade;

import java.util.List;

/**
 * @author Philip Urban
 */
public interface UpgradeHolder<T> {

    int getId();

    String getName();

    String getDescription();

    T getObject();

    Upgrade getUpgrade(String id);

    List<Upgrade> getUpgrades();

    void save();
}
