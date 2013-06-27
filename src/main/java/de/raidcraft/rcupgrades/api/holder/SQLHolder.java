package de.raidcraft.rcupgrades.api.holder;

import de.raidcraft.RaidCraft;
import de.raidcraft.rcupgrades.RCUpgradesPlugin;
import de.raidcraft.rcupgrades.api.upgrade.Upgrade;
import de.raidcraft.rcupgrades.tables.THolder;
import de.raidcraft.rcupgrades.tables.TUpgrade;
import de.raidcraft.rcupgrades.tables.TUpgradeData;
import org.bukkit.configuration.ConfigurationSection;

/**
 * @author Philip Urban
 */
public class SQLHolder extends AbstractHolder {

    int id;

    public SQLHolder(int id, ConfigurationSection config) {

        super(config);
        THolder tHolder = RaidCraft.getDatabase(RCUpgradesPlugin.class).find(THolder.class, id);
        if(tHolder != null) {
            for(TUpgrade tUpgrade : tHolder.getUpgrades()) {
                Upgrade upgrade = getUpgrade(tUpgrade.getName());
                if(upgrade == null) continue;
                // set saved level
                upgrade.setLevel(tUpgrade.getLevel());
                // set saved data
                for(TUpgradeData tUpgradeData : tUpgrade.getData()) {
                    upgrade.set(tUpgradeData.getKey(), tUpgradeData.getValue());
                }
            }
        } else {
            tHolder = new THolder();
            tHolder.setName(getName());
            RaidCraft.getDatabase(RCUpgradesPlugin.class).save(tHolder);
            this.id = tHolder.getId();
        }
        save();
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

        THolder tHolder = RaidCraft.getDatabase(RCUpgradesPlugin.class).find(THolder.class, id);
        for(Upgrade upgrade : getUpgrades()) {
            // get existing upgrades
            TUpgrade tUpgrade = RaidCraft.getDatabase(RCUpgradesPlugin.class).find(TUpgrade.class)
                    .where().eq("holder_id", id).eq("name", upgrade.getName()).findUnique();
            // create new if not exists
            if(tUpgrade == null) {
                tUpgrade = new TUpgrade();
                tUpgrade.setName(upgrade.getName());
                tUpgrade.setHolderId(tHolder);
                RaidCraft.getDatabase(RCUpgradesPlugin.class).save(tUpgrade);
            }
            // set level and save
            tUpgrade.setLevel(upgrade.getCurrentLevel());
            RaidCraft.getDatabase(RCUpgradesPlugin.class).save(tUpgrade);

            // save upgrades data
            for(String key : upgrade.getKeys(false)) {
                // get existing data
                TUpgradeData tUpgradeData = RaidCraft.getDatabase(RCUpgradesPlugin.class).find(TUpgradeData.class)
                        .where().eq("upgrade_id", tUpgrade.getId()).eq("key", key).findUnique();
                // create new if not exists
                if(tUpgradeData == null) {
                    tUpgradeData = new TUpgradeData();
                    tUpgradeData.setKey(key);
                    tUpgradeData.setUpgradeId(tUpgrade);
                    RaidCraft.getDatabase(RCUpgradesPlugin.class).save(tUpgradeData);
                }
                tUpgradeData.setValue(upgrade.getString(key));
                RaidCraft.getDatabase(RCUpgradesPlugin.class).save(tUpgradeData);
            }
        }
    }
}
