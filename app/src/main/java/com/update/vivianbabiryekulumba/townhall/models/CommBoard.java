package com.update.vivianbabiryekulumba.townhall.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CommBoard {

    @SerializedName("community_board")
    @Expose
    private String communityBoard;
    @SerializedName("zip_codes")
    @Expose
    private String zipCodes;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("neighborhoods")
    @Expose
    private String neighborhoods;
    @SerializedName("cb_info")
    @Expose
    private CbInfo cbInfo;

    public String getCommunityBoard() {
        return communityBoard;
    }

    public void setCommunityBoard(String communityBoard) {
        this.communityBoard = communityBoard;
    }

    public String getZipCodes() {
        return zipCodes;
    }

    public void setZipCodes(String zipCodes) {
        this.zipCodes = zipCodes;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getNeighborhoods() {
        return neighborhoods;
    }

    public void setNeighborhoods(String neighborhoods) {
        this.neighborhoods = neighborhoods;
    }

    public CbInfo getCbInfo() {
        return cbInfo;
    }

    public void setCbInfo(CbInfo cbInfo) {
        this.cbInfo = cbInfo;
    }

}
