package de.raidcraft.rcupgrades.tables;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

/**
 * @author Philip Urban
 */
@Getter
@Setter
@Entity
@Table(name = "rcupgrades_upgrades")
public class TUpgrade {

    @Id
    private int id;
    private String name;
    @ManyToOne
    private TUpgradeHolder holder;
    @OneToMany(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "upgrade_id")
    private Set<TUpgradeLevel> levels;
}
