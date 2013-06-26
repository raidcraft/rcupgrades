package de.raidcraft.rcupgrades.tables;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
}
