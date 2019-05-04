package com.akhmadreiza.wishlisted.service;

import com.akhmadreiza.wishlisted.apis.Wishes;
import com.akhmadreiza.wishlisted.apis.WishesAddRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface WishesService {
    List<Wishes> getAllWishes(String wishlistId);

    Wishes getWish(String wishlistId, String wishId);

    @Deprecated
    Wishes addWish(String wishlistId, Wishes wishes);

    WishesAddRequest addWish(String wishlistId, WishesAddRequest wishesAddRequest);

    Wishes updateWish(String wishlistId, String wishesId, Wishes wishes);

    void deleteWish(String wishlistId, String wishId);
}
