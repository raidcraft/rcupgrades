package de.raidcraft.rcupgrades.upgrades;

import de.raidcraft.rcupgrades.RCUpgradesPlugin;
import de.raidcraft.rcupgrades.api.upgrade.Upgrade;
import de.raidcraft.rcupgrades.api.upgrade.UpgradeInformation;
import de.raidcraft.util.CaseInsensitiveMap;
import de.raidcraft.util.StringUtils;

import java.util.Map;

/**
 * @author Philip Urban
 */
public class UpgradeManager {

    private RCUpgradesPlugin plugin;
    private Map<String, Class<? extends Upgrade>> registeredUpgrades = new CaseInsensitiveMap<>();

    public UpgradeManager(RCUpgradesPlugin plugin) {

        this.plugin = plugin;
    }

    public void registerUpgrade(Class<? extends Upgrade> clazz) {

        String name = StringUtils.formatName(clazz.getAnnotation(UpgradeInformation.class).name());
        registeredUpgrades.put(name, clazz);
    }

    public Class<? extends Upgrade> getUpgrade(String name) {

        return registeredUpgrades.get(name);
    }

}
