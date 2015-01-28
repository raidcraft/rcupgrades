package de.raidcraft.rcupgrades.tables;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Philip Urban
 */
@Getter
@Setter
@Entity
@Table(name = "rcupgrades_level_info")
public class TLevelInfo {

    @Id
    private int id;
    private String identifier;
    private String name;
    private int levelNumber;
    private String requirementDescription;
    private String rewardDescription;
    @ManyToOne
    private TUpgradeInfo upgradeInfo;
}
