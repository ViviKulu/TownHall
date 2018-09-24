package com.example.vivianbabiryekulumba.townhall.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CbInfo {

    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("latitude")
    @Expose
    private String latitude;
    @SerializedName("longitude")
    @Expose
    private String longitude;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("fax")
    @Expose
    private String fax;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("website")
    @Expose
    private String website;
    @SerializedName("chair")
    @Expose
    private String chair;
    @SerializedName("district_manager")
    @Expose
    private String districtManager;
    @SerializedName("board_meeting")
    @Expose
    private String boardMeeting;
    @SerializedName("cabinet_meeting")
    @Expose
    private String cabinetMeeting;
    @SerializedName("precinct")
    @Expose
    private String precinct;
    @SerializedName("precinct_phone")
    @Expose
    private String precinctPhone;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getChair() {
        return chair;
    }

    public void setChair(String chair) {
        this.chair = chair;
    }

    public String getDistrictManager() {
        return districtManager;
    }

    public void setDistrictManager(String districtManager) {
        this.districtManager = districtManager;
    }

    public String getBoardMeeting() {
        return boardMeeting;
    }

    public void setBoardMeeting(String boardMeeting) {
        this.boardMeeting = boardMeeting;
    }

    public String getCabinetMeeting() {
        return cabinetMeeting;
    }

    public void setCabinetMeeting(String cabinetMeeting) {
        this.cabinetMeeting = cabinetMeeting;
    }

    public String getPrecinct() {
        return precinct;
    }

    public void setPrecinct(String precinct) {
        this.precinct = precinct;
    }

    public String getPrecinctPhone() {
        return precinctPhone;
    }

    public void setPrecinctPhone(String precinctPhone) {
        this.precinctPhone = precinctPhone;
    }


}