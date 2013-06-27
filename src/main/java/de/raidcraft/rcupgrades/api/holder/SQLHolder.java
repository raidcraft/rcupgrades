package de.raidcraft.rcupgrades.api.holder;

import de.raidcraft.RaidCraft;
import de.raidcraft.rcupgrades.RCUpgradesPlugin;
import de.raidcraft.rcupgrades.api.upgrade.Upgrade;
import de.raidcraft.rcupgrades.tables.THolder;
import de.raidcraft.rcupgrades.tables.TUpgrade;
import org.bukkit.configuration.ConfigurationSection;

/**
 * @author Philip Urban
 */
public class SQLHolder extends AbstractHolder {

    int id;

    public SQLHolder(int id, ConfigurationSection config) {

        super(config);
        // TODO load holder from database, set saved upgrades, upgrade data and levels. Create new if saved holder couldn't found.
        THolder tHolder = RaidCraft.getDatabase(RCUpgradesPlugin.class).find(THolder.class, id);
        if(tHolder == null) {
            save();
        }
        else {

            for(TUpgrade tUpgrade : tHolder.getUpgrades()) {
                Upgrade upgrade = getUpgrade(tUpgrade.getName());
                if(upgrade == null) continue;

            }
        }
    }

    private SQLHolder(ConfigurationSection config) {

        super(config);
    }

    @Override
    public int getId() {

        return id;
    }

    @Override
    public void save() {

        //TODO: save holder, upgrades and upgrade data but do not delete old data (only update if already exists)

//        THolder tHolder = RaidCraft.getDatabase(RCUpgradesPlugin.class).find(THolder.class, id);
//        if(tHolder == null) {
//            tHolder = new THolder();
//            tHolder.setName(getName());
//        }
//
//        Set<TUpgrade> tUpgrades = new HashSet<>();
//        for(Upgrade upgrade : getUpgrades()) {
//
//            TUpgrade tUpgrade = null;
//            for(TUpgrade existingUpgradeEntry : tHolder.getUpgrades()) {
//
//                if(existingUpgradeEntry.getName().equalsIgnoreCase(upgrade.getName())) {
//                    tUpgrade = existingUpgradeEntry;
//                }
//            }
//            if(tUpgrade == null) {
//                tUpgrade = new TUpgrade();
//            }
//            tUpgrade.set
//            Set<TUpgradeData> data = new HashSet<>();
//            for(String key : upgrade.getKeys(false)) {
//
//                TUpgradeData tUpgradeData = new TUpgradeData();
//                tUpgradeData.setKey(key);
//                tUpgradeData.setValue(upgrade.getString(key));
//                data.add(tUpgradeData);
//            }
//            tUpgrade.setData(data);
//            tUpgrades.add(tUpgrade);
//        }
//
//
//            TUpgrade tUpgrade = new TUpgrade();
//            tUpgrade.setName(upgrade.getName());
//            tUpgrade.setLevel(upgrade.getCurrentLevel());
//            Set<TUpgradeData> data = new HashSet<>();
//            for(String key : upgrade.getKeys(false)) {
//
//                TUpgradeData tUpgradeData = new TUpgradeData();
//                tUpgradeData.setKey(key);
//                tUpgradeData.setValue(upgrade.getString(key));
//                data.add(tUpgradeData);
//            }
//            tUpgrade.setData(data);
//            tUpgrades.add(tUpgrade);
//        }
//        upgrades = tUpgrades;
//
//        RaidCraft.getDatabase(RCUpgradesPlugin.class).save(tHolder);
    }
}
