package de.raidcraft.rcupgrades.api.upgrade;

import de.raidcraft.rcupgrades.api.level.UpgradeLevel;

import java.util.*;

/**
 * @author Philip Urban
 */
public class SimpleUpgrade<T> extends AbstractUpgrade<T> {

    private SortedMap<Integer, UpgradeLevel<T>> levels = new TreeMap<>();

    public SimpleUpgrade(String name, String description, List<UpgradeLevel<T>> levels) {

        super(name, description);
        for(UpgradeLevel<T> upgradeLevel : levels) {
            this.levels.put(upgradeLevel.getNumber(), upgradeLevel);
        }
    }

    @Override
    public UpgradeLevel<T> getHighestLockedLevel() {

        UpgradeLevel<T> upgradeLevel = null;
        for(Map.Entry<Integer, UpgradeLevel<T>> entry : levels.entrySet()) {
            if(!entry.getValue().isUnlocked() && (upgradeLevel == null || upgradeLevel.getNumber() < entry.getValue().getNumber())) {
                upgradeLevel = entry.getValue();
            }
        }
        return upgradeLevel;
    }

    @Override
    public UpgradeLevel<T> getLevel(int level) {

        return levels.get(level);
    }

    @Override
    public List<UpgradeLevel<T>> getLevels() {

        if(levels.values() == null || levels.values().size() == 0) {
            return new ArrayList<>();
        }
        return new ArrayList<>(levels.values());
    }
}
