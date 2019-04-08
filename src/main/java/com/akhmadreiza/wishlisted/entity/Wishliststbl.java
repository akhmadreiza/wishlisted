package com.akhmadreiza.wishlisted.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Wishliststbl {

    @Id
    @Size(max = 191)
    private String id;

    @Size(max = 191)
    private String name;

    @Size(max = 191)
    private String dtCreated;

    @Size(max = 191)
    private String createdBy;

    @Size(max = 191)
    private String dtUpdated;

    @Size(max = 191)
    private String updatedBy;
    private boolean completed;

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

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
