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
@Table(name = "rcupgrades_levels")
public class TUpgradeLevel {

    @Id
    private int id;
    private String identifier;
    private boolean unlocked;
    @ManyToOne
    private TUpgrade upgrade;
}
