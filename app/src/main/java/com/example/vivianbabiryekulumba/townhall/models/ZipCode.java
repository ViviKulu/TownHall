package com.example.vivianbabiryekulumba.townhall.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ZipCode {

    @SerializedName("zip_code")
    @Expose
    private String zipCode;
    @SerializedName("community_board")
    @Expose
    private String communityBoard;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("neighborhoods")
    @Expose
    private String neighborhoods;
    @SerializedName("cb_info")
    @Expose
    private CbInfo cbInfo;
    @SerializedName("neighborhood")
    @Expose
    private String neighborhood;

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCommunityBoard() {
        return communityBoard;
    }

    public void setCommunityBoard(String communityBoard) {
        this.communityBoard = communityBoard;
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

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

}
