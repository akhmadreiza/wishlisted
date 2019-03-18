package com.akhmadreiza.wishlisted.endpoint;

import com.akhmadreiza.wishlisted.apis.Wishlists;
import com.akhmadreiza.wishlisted.service.WishlistService;
import com.ara27.arautil.general.GeneralUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class WishlistEndpoint {

    @Autowired
    private WishlistService wishlistService;

    private GeneralUtil araUtil = new GeneralUtil();

    @GetMapping(value = "/wishlists")
    public List<Wishlists> getAllWishList() {
        return wishlistService.getAllWishlist();
    }

    @GetMapping(value = "/wishlists/{id}")
    public Wishlists getWishListById(@PathVariable("id") String id) {
        return wishlistService.getWishlistById(id);
    }

    @PostMapping(value = "/wishlists")
    public ResponseEntity<Wishlists> addWishlist(@RequestBody @Valid Wishlists wishlists) {
        wishlists.setId(araUtil.getUUID());
        wishlists.setDtCreated(araUtil.getCurrentLocalDateTime());
        wishlists.setCreatedBy(wishlists.getCreatedBy() == null || wishlists.getCreatedBy().isEmpty() ? "DEFAULT_USER" : wishlists.getCreatedBy());
        return new ResponseEntity<Wishlists>(wishlistService.addWishlist(wishlists), HttpStatus.CREATED);
    }

    @PutMapping(value = "/wishlists/{id}")
    public ResponseEntity<Wishlists> updateWishlist(@PathVariable("id") String id, @RequestBody @Valid Wishlists wishlists) {
        Wishlists oldWishlists = wishlistService.getWishlistById(id);
        if (oldWishlists != null) {
            wishlists.setId(oldWishlists.getId());
            wishlists.setDtUpdated(araUtil.getCurrentLocalDateTime());
            wishlists.setUpdatedBy(wishlists.getUpdatedBy() == null || wishlists.getUpdatedBy().isEmpty() ? "DEFAULT_USER" : wishlists.getUpdatedBy());
            return new ResponseEntity<>(wishlistService.updateWishlists(wishlists), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
