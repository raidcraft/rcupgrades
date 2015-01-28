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
@Table(name = "rcupgrades_holders")
public class TUpgradeHolder {

    @Id
    private int id;
    private String name;
    @OneToMany(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "holder_id")
    private Set<TUpgrade> upgrades;
}
