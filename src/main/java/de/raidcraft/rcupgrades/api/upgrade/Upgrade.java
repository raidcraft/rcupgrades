package de.raidcraft.rcupgrades.api.upgrade;

/**
 * @author Philip Urban
 */
public interface Upgrade {

    public int getAvailableLevels();

    public int getCurrentLevel();

    public void increaseLevel();

    public void decreaseLevel();

    public void setLevel(int level);
}
