package de.raidcraft.rcupgrades.api.holder;

import de.raidcraft.api.requirement.Requirement;
import de.raidcraft.api.requirement.RequirementManager;
import de.raidcraft.api.reward.Reward;
import de.raidcraft.api.reward.RewardManager;
import de.raidcraft.rcupgrades.api.level.SimpleUpgradeLevel;
import de.raidcraft.rcupgrades.api.level.UpgradeLevel;
import de.raidcraft.rcupgrades.api.upgrade.SimpleUpgrade;
import de.raidcraft.rcupgrades.api.upgrade.Upgrade;
import org.bukkit.configuration.ConfigurationSection;

import java.util.List;

/**
 * @author Philip Urban
 */
public abstract class ConfigurationUpgradeHolder<T> extends AbstractUpgradeHolder<T> {

    protected ConfigurationUpgradeHolder(T object, ConfigurationSection config) {

        this.object = object;
        this.name = config.getString("name");
        this.description = config.getString("description");

        ConfigurationSection upgradesSection = config.getConfigurationSection("upgrades");
        if (upgradesSection == null) return;

        for (String key : upgradesSection.getKeys(false)) {
            ConfigurationSection upgradeSection = upgradesSection.getConfigurationSection(key);
            String id = key;
            String name = upgradeSection.getString("name");
            String description = upgradeSection.getString("description");

            ConfigurationSection levels = upgradeSection.getConfigurationSection("level");
            Upgrade upgrade = new SimpleUpgrade(id, name, description);
            if (levels != null) {
                for (String levelIdentifier : levels.getKeys(false)) {
                    ConfigurationSection level = levels.getConfigurationSection(levelIdentifier);
                    String levelName = level.getString("name");
                    boolean stored = level.getBoolean("stored", true);
                    int levelNumber = level.getInt("level", 0);
                    List<String> requirementDescription = level.getStringList("requirement-desc");
                    List<String> rewardDescription = level.getStringList("reward-desc");

                    UpgradeLevel<T> upgradeLevel = new SimpleUpgradeLevel<T>(this, levelIdentifier, levelNumber, levelName, stored, requirementDescription, rewardDescription);

                    // requirements
                    ConfigurationSection requirements = level.getConfigurationSection("requirements");
                    List<Requirement<T>> requirementList = RequirementManager.createRequirements(upgradeLevel, requirements);
                    upgradeLevel.setRequirements(requirementList);

                    // rewards
                    ConfigurationSection rewards = level.getConfigurationSection("rewards");
                    List<Reward<T>> rewardsList = RewardManager.createRewards(rewards);
                    upgradeLevel.setRewards(rewardsList);

                    upgrade.addLevel(upgradeLevel);
                }
            }

            upgrades.put(upgrade.getId(), upgrade);
        }
    }
}
