package com.akhmadreiza.wishlisted.apis;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Wishes {
    private String name;

    @JsonProperty(value = "checked")
    private boolean checked;

    private String dtCreated;
    private String dtUpdated;
    private String wishlistId;

    public Wishes(String name, boolean checked, String dtCreated, String dtUpdated, String wishlistId) {
        this.name = name;
        this.checked = checked;
        this.dtCreated = dtCreated;
        this.dtUpdated = dtUpdated;
        this.wishlistId = wishlistId;
    }

    public String getWishlistId() {
        return wishlistId;
    }

    public void setWishlistId(String wishlistId) {
        this.wishlistId = wishlistId;
    }

    public Wishes() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public String getDtCreated() {
        return dtCreated;
    }

    public void setDtCreated(String dtCreated) {
        this.dtCreated = dtCreated;
    }

    public String getDtUpdated() {
        return dtUpdated;
    }

    public void setDtUpdated(String dtUpdated) {
        this.dtUpdated = dtUpdated;
    }
}
