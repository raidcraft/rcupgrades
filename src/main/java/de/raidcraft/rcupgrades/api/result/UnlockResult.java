package de.raidcraft.rcupgrades.api.unlockresult;

/**
 * @author Philip Urban
 */
public class UnlockResult {

    private boolean successful;
    private String shortReason;
    private String longReason;

    public UnlockResult() {}

    public UnlockResult(boolean successful, String shortReason, String longReason) {

        this.successful = successful;
        this.shortReason = shortReason;
        this.longReason = longReason;
    }

    public void clearReasons() {

        this.longReason = null;
        this.shortReason = null;
    }

    public void setSuccessful(boolean successful) {

        this.successful = successful;
    }

    public void setShortReason(String shortReason) {

        this.shortReason = shortReason;
    }

    public void setLongReason(String longReason) {

        this.longReason = longReason;
    }

    public boolean isSuccessful() {

        return successful;
    }

    public String getLongReason() {

        return longReason;
    }

    public String getShortReason() {

        return shortReason;
    }
}
