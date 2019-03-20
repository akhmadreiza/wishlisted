package com.akhmadreiza.wishlisted.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Wishliststbl {

    @Id
    private String id;
    private String name;
    private String dtCreated;
    private String createdBy;
    private String dtUpdated;
    private String updatedBy;

    @OneToMany(mappedBy = "wishliststbl", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Wishestbl> wishestbl;

    public List<Wishestbl> getWishestbl() {
        return wishestbl;
    }

    public void setWishestbl(List<Wishestbl> wishestbl) {
        this.wishestbl = wishestbl;
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
