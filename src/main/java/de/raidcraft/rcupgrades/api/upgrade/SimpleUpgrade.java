package de.raidcraft.rcupgrades.api.upgrade;

import de.raidcraft.rcupgrades.api.level.UpgradeLevel;

import java.util.*;

/**
 * @author Philip Urban
 */
public class SimpleUpgrade extends AbstractUpgrade {

    private SortedMap<Integer, UpgradeLevel> levels = new TreeMap<>();

    public SimpleUpgrade(String id, String name, String description, List<UpgradeLevel> levels) {

        super(id, name, description);
        for(UpgradeLevel upgradeLevel : levels) {
            this.levels.put(upgradeLevel.getNumber(), upgradeLevel);
        }
    }

    @Override
    public UpgradeLevel getHighestLockedLevel() {

        UpgradeLevel upgradeLevel = null;
        for(Map.Entry<Integer, UpgradeLevel> entry : levels.entrySet()) {
            if(!entry.getValue().isUnlocked() && (upgradeLevel == null || upgradeLevel.getNumber() < entry.getValue().getNumber())) {
                upgradeLevel = entry.getValue();
            }
        }
        return upgradeLevel;
    }

    @Override
    public UpgradeLevel getLevel(int level) {

        return levels.get(level);
    }

    @Override
    public List<UpgradeLevel> getLevels() {

        if(levels.values() == null || levels.values().size() == 0) {
            return new ArrayList<>();
        }
        return new ArrayList<>(levels.values());
    }
}
