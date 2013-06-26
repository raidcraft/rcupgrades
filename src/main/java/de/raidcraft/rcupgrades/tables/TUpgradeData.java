package de.raidcraft.rcupgrades.tables;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Philip Urban
 */
@Entity
@Table(name = "rcupgrades_upgrade_data")
public class TUpgradeData {

    @Id
    private int id;
    @ManyToOne
    private TUpgrade upgradeId;
    private String key;
    private String value;

    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public TUpgrade getUpgradeId() {

        return upgradeId;
    }

    public void setUpgradeId(TUpgrade upgradeId) {

        this.upgradeId = upgradeId;
    }

    public String getKey() {

        return key;
    }

    public void setKey(String key) {

        this.key = key;
    }

    public String getValue() {

        return value;
    }

    public void setValue(String value) {

        this.value = value;
    }
}
