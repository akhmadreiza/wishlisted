package com.akhmadreiza.wishlisted.converter;


import com.akhmadreiza.wishlisted.apis.Wishlists;
import com.akhmadreiza.wishlisted.entity.Wishliststbl;

public class WishlistTblConverter {
    public void convert(Wishliststbl wishliststbl, Wishlists wishlists){
        wishlists = new Wishlists(wishliststbl);
    }
}
