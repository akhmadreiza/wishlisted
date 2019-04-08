package com.akhmadreiza.wishlisted.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

@Entity
public class Wishestbl {
    @Id
    @Size(max = 191)
    private String id;

    @Size(max = 191)
    private String name;
    private boolean checked;

    @Size(max = 191)
    private String dtCreated;

    @Size(max = 191)
    private String dtUpdated;

    @ManyToOne
    @JoinColumn(name = "wltblid", columnDefinition = "varchar(191)")
    //add column definition due to error when creating with mariadb utf8mb4
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
