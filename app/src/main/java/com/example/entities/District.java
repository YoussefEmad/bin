package com.example.entities;

public class District {
    private int aisleID;
    private int zoneID;
    private String aisleName;

    public District(int i, String s) {
    }

    public District(int disID, int zoneID, String aisleName) {
        this.aisleID = disID;
        this.zoneID = zoneID;
        this.aisleName = aisleName;
    }

    public District() {

    }

    public int getAisleID() {
        return aisleID;
    }

    public void setAisleID(int aisleID) {
        this.aisleID = aisleID;
    }

    public int getZoneID() {
        return zoneID;
    }

    public void setZoneID(int zoneID) {
        this.zoneID = zoneID;
    }

    public String getAisleName() {
        return aisleName;
    }

    public void setAisleName(String aisleName) {
        this.aisleName = aisleName;
    }
}
