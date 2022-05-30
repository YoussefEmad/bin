package com.example.entities;

import com.google.gson.annotations.SerializedName;

public class States {
    @SerializedName("zoneID")
    private int zoneID;

    @SerializedName("zoneName")
    private String zoneName;

    public States() {
    }

    public States(int zoneID, String zoneName) {
        this.zoneID = zoneID;
        this.zoneName = zoneName;
    }

    public int getZoneID() {
        return zoneID;
    }

    public void setZoneID(int zoneID) {
        this.zoneID = zoneID;
    }

    public String getZoneName() {
        return zoneName;
    }

    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;
    }
}
