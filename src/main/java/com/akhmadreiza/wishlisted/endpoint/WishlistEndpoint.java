package com.akhmadreiza.wishlisted.endpoint;

import com.akhmadreiza.wishlisted.apis.Wishlists;
import com.akhmadreiza.wishlisted.service.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WishlistEndpoint {

    @Autowired
    private WishlistService wishlistService;

    @GetMapping(value = "/wishlists")
    public ResponseEntity<List<Wishlists>> getAllWishList(){
        List<Wishlists> wishlistsList = wishlistService.getAllWishlist();
        return new ResponseEntity<List<Wishlists>>(wishlistsList, HttpStatus.OK);
    }
}
