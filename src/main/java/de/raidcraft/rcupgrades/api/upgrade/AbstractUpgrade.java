package de.raidcraft.rcupgrades.api.upgrade;

import de.raidcraft.util.StringUtils;
import org.bukkit.configuration.MemoryConfiguration;

/**
 * @author Philip Urban
 */
public abstract class AbstractUpgrade extends MemoryConfiguration implements Upgrade {

    private String name;
    private String friendlyName;
    private String description;
    private int maxLevel;

    public AbstractUpgrade() {

       this.name = StringUtils.formatName(getClass().getAnnotation(UpgradeInformation.class).name());
    }

    public String getName() {

        return name;
    }

    public String getFriendlyName() {

        return friendlyName;
    }

    public void setFriendlyName(String friendlyName) {

        this.friendlyName = friendlyName;
    }

    public String getDescription() {

        return description;
    }

    public void setDescription(String description) {

        this.description = description;
    }

    public void setMaxLevel(int maxLevel) {

        this.maxLevel = maxLevel;
    }

    public int getMaxLevel() {

        return maxLevel;
    }
}
