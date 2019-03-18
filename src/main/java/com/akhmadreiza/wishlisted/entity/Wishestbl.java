package com.akhmadreiza.wishlisted.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Wishestbl {
    @Id
    private String id;
    private String name;
    private boolean checked;
    private String dtCreated;
    private String dtUpdated;

    @ManyToOne
    @JoinColumn(name = "wishliststbl_id")
    private Wishliststbl wishliststbl;

    public Wishliststbl getWishliststbl() {
        return wishliststbl;
    }

    public void setWishliststbl(Wishliststbl wishliststbl) {
        this.wishliststbl = wishliststbl;
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
