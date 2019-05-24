package com.akhmadreiza.wishlisted.endpoint;

import com.akhmadreiza.wishlisted.apis.Wishlists;
import com.akhmadreiza.wishlisted.config.JwtTokenUtil;
import com.akhmadreiza.wishlisted.constants.AuthenticationConstants;
import com.akhmadreiza.wishlisted.service.WishlistService;
import com.ara27.arautil.general.GeneralUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
public class WishlistEndpoint {

    @Autowired
    private WishlistService wishlistService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    private GeneralUtil araUtil = new GeneralUtil();

    @GetMapping(value = "/wishlists")
    public List<Wishlists> getAllWishList(@RequestHeader(value = "Authorization") String authToken) {
        final String userName = jwtTokenUtil.getUsernameFromToken(authToken.replace(AuthenticationConstants.TOKEN_PREFIX, ""));
        return wishlistService.getAllWishlistByUserName(userName);
    }

    @GetMapping(value = "/wishlists/{id}")
    public Wishlists getWishListById(@PathVariable("id") String id, @RequestHeader(value = "Authorization") String authToken) {
        final String userName = jwtTokenUtil.getUsernameFromToken(authToken.replace(AuthenticationConstants.TOKEN_PREFIX, ""));
        return wishlistService.getWishlistByIdAndUserName(id, userName);
    }

    @PostMapping(value = "/wishlists")
    public ResponseEntity<Wishlists> addWishlist(@RequestBody @Valid Wishlists wishlists, @RequestHeader(value = "Authorization") String authToken) {
        final String userName = jwtTokenUtil.getUsernameFromToken(authToken.replace(AuthenticationConstants.TOKEN_PREFIX, ""));
        wishlists.setId(araUtil.getUUID());
        wishlists.setDtCreated(araUtil.getCurrentLocalDateTime());
        wishlists.setCreatedBy(wishlists.getCreatedBy() == null || wishlists.getCreatedBy().isEmpty() ? userName : wishlists.getCreatedBy());
        return new ResponseEntity<Wishlists>(wishlistService.addWishlist(wishlists, userName), HttpStatus.CREATED);
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
