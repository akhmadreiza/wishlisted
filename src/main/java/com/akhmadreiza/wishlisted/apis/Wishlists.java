package com.akhmadreiza.wishlisted.apis;

import com.akhmadreiza.wishlisted.entity.Wishliststbl;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"id", "name", "dtCreated", "createdBy", "dtUpdated", "updatedBy"})
public class Wishlists {
    private String id;

    @NotNull
    private String name;
    private String dtCreated;
    private String createdBy;
    private String dtUpdated;
    private String updatedBy;

    public Wishlists() {
    }

    public Wishlists(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Wishlists(Wishliststbl wishliststbl) {
        this.id = wishliststbl.getId();
        this.name = wishliststbl.getName();
        this.dtCreated = wishliststbl.getDtCreated();
        this.createdBy = wishliststbl.getCreatedBy();
        this.dtUpdated = wishliststbl.getDtUpdated();
        this.updatedBy = wishliststbl.getUpdatedBy();
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
