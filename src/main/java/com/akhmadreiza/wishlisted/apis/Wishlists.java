package com.akhmadreiza.wishlisted.apis;

public class Wishlists {
    private String id;
    private String name;
    private String dtCreated;
    private String createdBy;
    private String dtUpdated;
    private String updatedBy;

    public Wishlists() {
    }

    public Wishlists(String id, String name, String dtCreated, String createdBy, String dtUpdated, String updatedBy) {
        this.id = id;
        this.name = name;
        this.dtCreated = dtCreated;
        this.createdBy = createdBy;
        this.dtUpdated = dtUpdated;
        this.updatedBy = updatedBy;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDtCreated() {
        return dtCreated;
    }

    public void setDtCreated(String dtCreated) {
        this.dtCreated = dtCreated;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getDtUpdated() {
        return dtUpdated;
    }

    public void setDtUpdated(String dtUpdated) {
        this.dtUpdated = dtUpdated;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
}
