package com.akhmadreiza.wishlisted.service;

import com.akhmadreiza.wishlisted.apis.Wishes;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface WishesService {
    List<Wishes> getAllWishes(String wishlistId);

    Wishes getWish(String wishlistId, String wishId);

    Wishes addWish(String wishlistId, Wishes wishes);

    Wishes updateWish(String wishlistId, String wishesId);
}
