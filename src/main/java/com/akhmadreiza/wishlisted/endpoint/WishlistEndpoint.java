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
        return new ResponseEntity<>(wishlistService.updateWishlists(wishlists, id), HttpStatus.OK);
    }

    @DeleteMapping(value = "/wishlists/{id}")
    public ResponseEntity<?> deleteWishlist(@PathVariable("id") String id) {
        try {
            wishlistService.deleteWishlists(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
