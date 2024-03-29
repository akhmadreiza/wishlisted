package com.akhmadreiza.wishlisted.endpoint;

import com.akhmadreiza.wishlisted.apis.Wishes;
import com.akhmadreiza.wishlisted.apis.WishesAddRequest;
import com.akhmadreiza.wishlisted.service.WishesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
public class WishesEndpoint {

    @Autowired
    private WishesService wishesService;

    @PostMapping(value = "/wishlists/{wishlistsId}/wishes")
    public WishesAddRequest addWishes(@PathVariable("wishlistsId") String wishlistId, @RequestBody @Valid WishesAddRequest wishes) {
        return wishesService.addWish(wishlistId, wishes);
    }

    @GetMapping(value = "/wishlists/{wishlistsId}/wishes")
    public List<Wishes> getAllWishesByWishlistId(@PathVariable("wishlistsId") String wishlistsId) {
        return wishesService.getAllWishes(wishlistsId);
    }

    @GetMapping(value = "/wishlists/{wishlistsId}/wishes/{wishesId}")
    public Wishes getWisheshByWishlistIdAndId(@PathVariable("wishlistsId") String wishlistsId, @PathVariable("wishesId") String wishesId) {
        return wishesService.getWish(wishlistsId, wishesId);
    }

    @PutMapping(value = "/wishlists/{wishlistsId}/wishes/{wishesId}")
    public Wishes updateWish(@PathVariable("wishlistsId") String wishlistsId, @PathVariable("wishesId") String wishesId, @RequestBody @Valid Wishes wishes) {
        return wishesService.updateWish(wishlistsId, wishesId, wishes);
    }

    @DeleteMapping(value = "/wishlists/{wishlistsId}/wishes/{wishesId}")
    public ResponseEntity deleteWish(@PathVariable("wishlistsId") String wishlistsId, @PathVariable("wishesId") String wishesId) {
        wishesService.deleteWish(wishlistsId, wishesId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
