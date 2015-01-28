package de.raidcraft.rcupgrades.tables;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

/**
 * @author Philip Urban
 */
@Getter
@Setter
@Entity
@Table(name = "rcupgrades_upgrade_info")
public class TUpgradeInfo {

    @Id
    private int id;
    private String holderId;
    private String holderName;
    private String name;
    private String description;
    @OneToMany(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "upgrade_info_id")
    private Set<TLevelInfo> levelInfo;
}
