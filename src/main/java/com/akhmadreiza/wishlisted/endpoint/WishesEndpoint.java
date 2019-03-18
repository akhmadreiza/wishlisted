package com.akhmadreiza.wishlisted.endpoint;

import com.akhmadreiza.wishlisted.apis.Wishes;
import com.akhmadreiza.wishlisted.service.WishesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WishesEndpoint {

    @Autowired
    private WishesService wishesService;

    @PostMapping(value = "/wishlists/{wishlistsId}/wishes")
    public Wishes addWishes(@PathVariable("wishlistsId") String wishlistId, @RequestBody Wishes wishes) {
        return wishesService.addWish(wishlistId, wishes);
    }

    @GetMapping(value = "/wishlists/{wishlistsId}/wishes")
    public List<Wishes> getAllWishesByWishlistId(@PathVariable("wishlistsId") String wishlistsId) {
        return wishesService.getAllWishes(wishlistsId);
    }
}
