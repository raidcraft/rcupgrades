package de.raidcraft.rcupgrades.api.holder;

import de.raidcraft.rcupgrades.api.upgrade.Upgrade;

import java.util.List;

/**
 * @author Philip Urban
 */
public interface Holder {

    public int getId();

    public String getName();

    public List<Upgrade> getUpgrades();
}
