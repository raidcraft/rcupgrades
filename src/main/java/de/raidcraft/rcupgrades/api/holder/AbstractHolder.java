package de.raidcraft.rcupgrades.api.holder;

import de.raidcraft.RaidCraft;
import de.raidcraft.rcupgrades.RCUpgradesPlugin;
import de.raidcraft.rcupgrades.api.upgrade.Upgrade;
import org.bukkit.configuration.ConfigurationSection;
import de.raidcraft.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Philip Urban
 */
public abstract class AbstractHolder implements Holder {

    private String name;
    private String description;
    private List<Upgrade> upgrades = new ArrayList<>();

    protected AbstractHolder(ConfigurationSection config) {

        name = StringUtils.formatName(config.getString("name"));
        description = config.getString("description");

        // set upgrades
        ConfigurationSection upgradesSection = config.getConfigurationSection("upgrades");
        for(String key : upgradesSection.getKeys(false)) {

            ConfigurationSection upgradeSection = upgradesSection.getConfigurationSection(key);
            String upgradeName = upgradeSection.getString("name");
            Class<? extends Upgrade> upgradeClass = RaidCraft.getComponent(RCUpgradesPlugin.class).getUpgradeManager().getUpgrade(upgradeName);
            if(upgradeClass == null) {
                RaidCraft.LOGGER.warning("No Upgrade Class found with name: " + upgradeName);
                continue;
            }
            Upgrade upgrade;
            try {
                upgrade = upgradeClass.newInstance();
            } catch (InstantiationException | IllegalAccessException e) {
                RaidCraft.LOGGER.warning(e.getMessage());
                continue;
            }
            // set max level
            upgrade.setMaxLevel(upgradeSection.getInt("max-level"));
            // set custom config values
            ConfigurationSection upgradeConfigSection = upgradeSection.getConfigurationSection("config");
            if(upgradeConfigSection != null) {
                for(String configKey : upgradeConfigSection.getKeys(false)) {
                    upgrade.set(configKey, upgradeConfigSection.get(configKey));
                }
            }
            upgrades.add(upgrade);
        }
    }

    @Override
    public Upgrade getUpgrade(String name) {

        for(Upgrade upgrade : upgrades) {
            if(upgrade.getName().equalsIgnoreCase(name)) {
                return upgrade;
            }
        }
        return null;
    }

    @Override
    public List<Upgrade> getUpgrades() {

        return upgrades;
    }

    @Override
    public String getName() {

        return name;
    }

    public String getDescription() {

        return description;
    }
}
