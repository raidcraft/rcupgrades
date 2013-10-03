package de.raidcraft.rcupgrades.api.upgrade;

import de.raidcraft.rcupgrades.api.level.UpgradeLevel;

import java.util.*;

/**
 * @author Philip Urban
 */
public class SimpleUpgrade extends AbstractUpgrade {

    private SortedMap<Integer, UpgradeLevel> levels = new TreeMap<>();

    public SimpleUpgrade(String id, String name, String description) {

        super(id, name, description);
    }

    @Override
    public void setLevels(List<UpgradeLevel> levels) {

        for(UpgradeLevel upgradeLevel : levels) {
            this.levels.put(upgradeLevel.getId(), upgradeLevel);
        }
    }

    @Override
    public void addLevel(UpgradeLevel level) {

        this.levels.put(level.getId(), level);
    }

    @Override
    public UpgradeLevel getHighestLockedLevel() {

        UpgradeLevel upgradeLevel = null;
        for(Map.Entry<Integer, UpgradeLevel> entry : levels.entrySet()) {
            if(!entry.getValue().isUnlocked() && (upgradeLevel == null || upgradeLevel.getId() < entry.getValue().getId())) {
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
