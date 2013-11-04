package de.raidcraft.rcupgrades;

import com.google.common.base.Joiner;
import de.raidcraft.RaidCraft;
import de.raidcraft.rcupgrades.api.holder.UpgradeHolder;
import de.raidcraft.rcupgrades.api.level.UpgradeLevel;
import de.raidcraft.rcupgrades.api.upgrade.Upgrade;
import de.raidcraft.rcupgrades.tables.TLevelInfo;
import de.raidcraft.rcupgrades.tables.TUpgradeHolder;
import de.raidcraft.rcupgrades.tables.TUpgradeInfo;
import de.raidcraft.util.StringUtils;
import org.bukkit.configuration.ConfigurationSection;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Philip Urban
 */
public class UpgradeManager {

    private Set<String> createdUpgradeInfo = new HashSet<>();


    /**
     * Load and returns existing UpgradeHolder.
     *
     */
    public <O> UpgradeHolder<O> loadDatabaseUpgradeHolder(O object, ConfigurationSection holderConfig, int id) {

        UpgradeHolder<O> upgradeHolder = new DatabaseUpgradeHolder<O>(object, holderConfig, id);
        createDatabaseUpgradeInfo(upgradeHolder);
        return upgradeHolder;
    }

    /**
     * Creates a new UpgradeHolder from given holder configuration and stores them in the database.
     *
     */
    public <O> UpgradeHolder createDatabaseUpgradeHolder(O object, ConfigurationSection holderConfig) {

        UpgradeHolder<O> upgradeHolder = new DatabaseUpgradeHolder<O>(object, holderConfig);
        upgradeHolder.save();
        return upgradeHolder;
    }

    public void deleteUpgradeHolder(int id) {

        TUpgradeHolder tUpgradeHolder = RaidCraft.getDatabase(RCUpgradesPlugin.class).find(TUpgradeHolder.class, id);
        RaidCraft.getDatabase(RCUpgradesPlugin.class).delete(tUpgradeHolder);
    }

    private <O> void createDatabaseUpgradeInfo(UpgradeHolder<O> upgradeHolder) {

        if(createdUpgradeInfo.contains(StringUtils.formatName(upgradeHolder.getName()))) return;
        createdUpgradeInfo.add(StringUtils.formatName(upgradeHolder.getName()));

        // delete existing
        List<TUpgradeInfo> tUpgradeInfos = RaidCraft.getDatabase(RCUpgradesPlugin.class)
                .find(TUpgradeInfo.class).where().ieq("holder_id", StringUtils.formatName(upgradeHolder.getName())).findList();
        RaidCraft.getDatabase(RCUpgradesPlugin.class).delete(tUpgradeInfos);

        // create new
        for(Upgrade upgrade : upgradeHolder.getUpgrades()) {
            TUpgradeInfo tUpgradeInfo = new TUpgradeInfo();
            tUpgradeInfo.setHolderId(StringUtils.formatName(upgradeHolder.getName()));
            tUpgradeInfo.setHolderName(upgradeHolder.getName());
            tUpgradeInfo.setDescription(upgrade.getDescription());
            tUpgradeInfo.setName(upgrade.getName());
            RaidCraft.getDatabase(RCUpgradesPlugin.class).save(tUpgradeInfo);

            // save level info
            for(UpgradeLevel level : upgrade.getLevels()) {

                TLevelInfo tLevelInfo = new TLevelInfo();
                tLevelInfo.setName(level.getName());
                tLevelInfo.setIdentifier(level.getId());
                tLevelInfo.setLevelNumber(level.getLevel());
                tLevelInfo.setUpgradeInfo(tUpgradeInfo);
                tLevelInfo.setRequirementDescription(Joiner.on("|").join(level.getRequirementDescription()));
                tLevelInfo.setRewardDescription(Joiner.on("|").join(level.getRewardDescription()));
                RaidCraft.getDatabase(RCUpgradesPlugin.class).save(tLevelInfo);
            }
        }

    }
}
