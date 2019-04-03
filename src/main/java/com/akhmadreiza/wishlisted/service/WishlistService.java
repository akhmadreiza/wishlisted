package com.akhmadreiza.wishlisted.service;

import com.akhmadreiza.wishlisted.apis.Wishlists;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface WishlistService {
    List<Wishlists> getAllWishlist();
    Wishlists getWishlistById(String id);
    Wishlists addWishlist(Wishlists wishlists);

    Wishlists updateWishlists(Wishlists wishlists, String id);
    void deleteWishlists(String id);
}
