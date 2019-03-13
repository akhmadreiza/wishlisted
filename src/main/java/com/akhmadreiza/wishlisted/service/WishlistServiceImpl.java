package com.akhmadreiza.wishlisted.service;

import com.akhmadreiza.wishlisted.apis.Wishlists;
import com.ara27.arautil.general.GeneralUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WishlistServiceImpl implements WishlistService {

    private GeneralUtil arautil = new GeneralUtil();

    @Override
    public List<Wishlists> getAllWishlist() {

        List<Wishlists> allWishlists = new ArrayList<>();

        Wishlists wishlists1 = new Wishlists();
        wishlists1.setId(arautil.getUUID());
        wishlists1.setName("wishlist for starter");
        wishlists1.setCreatedBy("SYSTEM");
        wishlists1.setDtCreated(arautil.getCurrentLocalDateTime());

        Wishlists wishlists2 = new Wishlists();
        wishlists2.setId(arautil.getUUID());
        wishlists2.setName("wishlist for starter");
        wishlists2.setCreatedBy("SYSTEM");
        wishlists2.setDtCreated(arautil.getCurrentLocalDateTime());


        allWishlists.add(wishlists1);
        allWishlists.add(wishlists2);
        return allWishlists;
    }
}
