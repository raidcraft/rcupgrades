package de.raidcraft.rcupgrades.tables;

import javax.persistence.*;
import java.util.Set;

/**
 * @author Philip Urban
 */
@Entity
@Table(name = "rcupgrades_upgrades")
public class TUpgrade {

    @Id
    private int id;
    private String name;
    private int level;
    @ManyToOne
    private THolder holderId;
    @OneToMany(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "upgrade_id")
    private Set<TUpgradeData> data;

    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public int getLevel() {

        return level;
    }

    public void setLevel(int level) {

        this.level = level;
    }

    public THolder getHolderId() {

        return holderId;
    }

    public void setHolderId(THolder holderId) {

        this.holderId = holderId;
    }

    public Set<TUpgradeData> getData() {

        return data;
    }

    public void setData(Set<TUpgradeData> data) {

        this.data = data;
    }
}
