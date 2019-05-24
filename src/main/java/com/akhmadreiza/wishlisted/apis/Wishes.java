package com.akhmadreiza.wishlisted.apis;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"id", "name", "checked", "dtCreated", "dtUpdated", "wishlistId"})
public class Wishes {
    private String id;
    @NotNull
    private String name;

    @JsonProperty(value = "checked")
    private boolean checked;

    private String dtCreated;
    private String dtUpdated;
    private String wishlistId;
    private Long price;

    public Wishes(String id, String name, boolean checked, String dtCreated, String dtUpdated, String wishlistId, Long price) {
        this.id = id;
        this.name = name;
        this.checked = checked;
        this.dtCreated = dtCreated;
        this.dtUpdated = dtUpdated;
        this.wishlistId = wishlistId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
}
