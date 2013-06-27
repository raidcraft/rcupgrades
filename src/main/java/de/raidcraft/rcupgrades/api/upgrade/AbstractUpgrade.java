package de.raidcraft.rcupgrades.api.upgrade;

import de.raidcraft.util.StringUtils;
import org.bukkit.configuration.MemoryConfiguration;

/**
 * @author Philip Urban
 */
public abstract class AbstractUpgrade extends MemoryConfiguration implements Upgrade {

    private String name;
    private int maxLevel;

    public AbstractUpgrade() {

       this.name = StringUtils.formatName(getClass().getAnnotation(UpgradeInformation.class).name());
    }

    public String getName() {

        return name;
    }

    public void setMaxLevel(int maxLevel) {

        this.maxLevel = maxLevel;
    }

}
